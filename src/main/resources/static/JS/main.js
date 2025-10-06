// ========================
// Config
// ========================
const API_DEMONSLAYER = '/api/characters'; // misma origin (Spring sirve todo en 8080)

// Elementos del DOM
const fighter1Select = document.getElementById('fighter1');
const fighter2Select = document.getElementById('fighter2');
const fighter1Image  = document.getElementById('fighter1Image');
const fighter2Image  = document.getElementById('fighter2Image');
const fightButton    = document.getElementById('fightButton');
const resultDiv      = document.getElementById('result');

// Estado global
let personajes = [];

// ========================
// Utilidades
// ========================
function etiquetaAldea(p) {
  // Soporta p.aldea.nombre o p.aldea_id / p.Aldea_id
  if (p && p.aldea && typeof p.aldea.nombre === 'string') return p.aldea.nombre;

  const id = p?.aldea_id ?? p?.Aldea_id;
  if (id === 1) return 'Cazadores';
  if (id === 2) return 'Demonios';
  return '';
}

function deduplicarPorNombreYAldea(lista) {
  // Crea una llave "nombre|aldea" y se queda con el primero que aparezca
  const vistos = new Set();
  const res = [];
  for (const p of lista) {
    const key = `${p?.nombre ?? ''}|${etiquetaAldea(p)}`;
    if (!vistos.has(key)) {
      vistos.add(key);
      res.push(p);
    }
  }
  return res;
}

function textoOption(p) {
  const ald = etiquetaAldea(p);
  return ald ? `${p.nombre} (${ald})` : p.nombre;
}

// ========================
// Carga de datos
// ========================
async function fetchData() {
  try {
    const res = await fetch(API_DEMONSLAYER, { headers: { 'Accept': 'application/json' } });
    if (!res.ok) throw new Error(`HTTP ${res.status}`);
    const data = await res.json();

    // Asegurar array
    if (!Array.isArray(data)) throw new Error('La API no devolvió un array');

    // Deduplicar por (nombre + aldea)
    personajes = deduplicarPorNombreYAldea(data);
  } catch (err) {
    console.error('Error al cargar los personajes:', err);
    personajes = [];
  }
  loadFighters();
}

// ========================
// Poblar selects (con índice)
// ========================
function loadFighters() {
  // Limpiar (dejando el primer option "-- Seleccioná --")
  [...fighter1Select.options].slice(1).forEach(() => fighter1Select.remove(1));
  [...fighter2Select.options].slice(1).forEach(() => fighter2Select.remove(1));

  personajes.forEach((p, idx) => {
    const o1 = document.createElement('option');
    o1.value = String(idx);       // usamos el índice del array
    o1.text  = textoOption(p);
    fighter1Select.appendChild(o1);

    const o2 = document.createElement('option');
    o2.value = String(idx);       // usamos el índice del array
    o2.text  = textoOption(p);
    fighter2Select.appendChild(o2);
  });

  // Selecciones iniciales distintas (si hay suficientes)
  if (fighter1Select.options.length > 1) {
    fighter1Select.selectedIndex = 1;
    actualizarImagen(1);
  }
  if (fighter2Select.options.length > 2) {
    fighter2Select.selectedIndex = 2;
    actualizarImagen(2);
  }
}

function personajePorIndex(idxStr) {
  const idx = Number(idxStr);
  return Number.isInteger(idx) && idx >= 0 && idx < personajes.length
    ? personajes[idx]
    : null;
}

// ========================
// UI: actualizar imágenes
// ========================
function actualizarImagen(n) {
  const select = n === 1 ? fighter1Select : fighter2Select;
  const img    = n === 1 ? fighter1Image  : fighter2Image;

  const p = personajePorIndex(select.value);
  img.src = (p && p.url_imagen) ? p.url_imagen : (n === 1 ? '/img/placeholder1.png' : '/img/placeholder2.png');
}

// Eventos de cambio
fighter1Select.addEventListener('change', () => actualizarImagen(1));
fighter2Select.addEventListener('change', () => actualizarImagen(2));

// ========================
// Lógica de pelea
// ========================
fightButton.addEventListener('click', () => {
  const p1 = personajePorIndex(fighter1Select.value);
  const p2 = personajePorIndex(fighter2Select.value);

  if (!p1 || !p2) {
    alert('Seleccioná ambos luchadores.');
    return;
  }
  if (fighter1Select.value === fighter2Select.value) {
    alert('Elegí personajes distintos.');
    return;
  }

  // Usamos "vida" como poder base; si no hay, generamos uno aleatorio
  const power1 = Number.isFinite(p1.vida) ? Number(p1.vida) : (Math.floor(Math.random() * 1000) + 500);
  const power2 = Number.isFinite(p2.vida) ? Number(p2.vida) : (Math.floor(Math.random() * 1000) + 500);

  const winner = power1 > power2 ? p1.nombre : power2 > power1 ? p2.nombre : '¡Empate!';
  resultDiv.textContent = `🏆 El ganador es: ${winner} 🥊 (P1: ${power1} vs P2: ${power2})`;
  resultDiv.classList.remove('hidden');
});

// ========================
// Inicio
// ========================
fetchData();
