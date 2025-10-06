package aplicationjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import aplicationjava.entity.Aldea;
import aplicationjava.entity.Pj;
import aplicationjava.entity.Poder;

@SpringBootApplication

@EntityScan("aplicationjava.entity") // Ensure this matches your entity package
@EnableJpaRepositories("aplicationjava.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
   	
		Aldea aldea1=new Aldea("Demonio");
		Aldea aldea2=new Aldea("Cazador");
		
		Poder poder1=new Poder("Lotos de hielo", 30000, "Arte demoniaco de sangre");
		Poder poder2=new Poder("Danza de la mariposa", 15000, "Respiracion deL insecto");
		Poder poder3=new Poder("Escudo de abanico", 15000, "Arte demoniaco de sangre" );
		Poder poder4=new Poder("Muro de mariposas", 10000, "Respiración del insecto" );
		Poder poder5=new Poder("Nube congelada", 0, "Arte demoniaco de sangre");
		Poder poder6=new Poder("Danza de la picadura de abeja", 1000, "Respiración del insecto");
		
		Pj pj1=new Pj("DOUMA", 100000, aldea1, poder1);
		Pj pj2=new Pj("SHINOBU", 50000, aldea2, poder2);
		
	int numeroRandom;	
	
		System.out.println("----------------------- PARTICIPANTES ----------------------- ");
		System.out.println("\n*** " + pj1.getNombre() + " *** \nNombre: "  + pj1.getNombre() + "\nAldea: " + pj1.getAldea().getNombre()  + "\nVida: " + pj1.getvida() + "\nTipo de poder: " + pj1.getPoder().getTipo()) ;
		System.out.println("\n*** " + pj2.getNombre() + " *** \nNombre: " + pj2.getNombre() + "\nAldea: " + pj2.getAldea().getNombre()  + "\nVida: " + pj2.getvida() + "\nTipo de poder: " + pj2.getPoder().getTipo()) ;
		System.out.println("\n----------------------- ¡INICIA LA BATALLA! -----------------------");
		
	while(pj1.getvida()>0 && pj2.getvida()>0)
	{
		System.out.println("\n****** TURNO DE " + pj1.getNombre() + " ****** \n" );
		numeroRandom = (int)(Math.random()*100);
		if (numeroRandom < 34) {
		pj1.setPoder(poder1);
		System.out.println(pj1.getNombre() + " LANZÓ: " + pj1.getPoder().getNombre() + "\nPoder de ataque: " + pj1.getPoder().getAtaque());
		System.out.println("¡¡" + pj2.getNombre() + " fue herido!!");
		pj2.setvida(pj2.getvida()-pj1.getPoder().getAtaque());
		}
		else {
			if (numeroRandom > 33 && numeroRandom < 67) {
			pj1.setPoder(poder3);
			System.out.println(pj1.getNombre() + " LANZÓ: " + pj1.getPoder().getNombre() + "\n" + pj1.getNombre() + "se defendió.");
			}
			else {
				if (numeroRandom > 66) {
				pj1.setPoder(poder5);
				System.out.println(pj1.getNombre() + " LANZÓ: " + pj1.getPoder().getNombre() + "\n" + pj2.getNombre() + "no puede respirar, pierde su turno.");
				}
			}
		}
	

	if (pj2.getvida() <= 0) { 
		System.out.println( "\nVida de " + pj2.getNombre() + ": " + 0);
		System.out.println(pj2.getNombre() + " ha muerto.");

	}
	else {
		System.out.println( "\nVida de " + pj2.getNombre() + ": " + pj2.getvida());
		System.out.println("\n****** TURNO DE " + pj2.getNombre() + " ****** \n" );
		numeroRandom = (int)(Math.random()*100);
		if (numeroRandom < 34) {
		pj2.setPoder(poder2);
		System.out.println(pj2.getNombre() + " LANZÓ: " + pj2.getPoder().getNombre() + "\nPoder de ataque: " + pj2.getPoder().getAtaque());
		System.out.println("¡¡" + pj1.getNombre() + " fue herido!!");
		pj1.setvida(pj1.getvida()-pj2.getPoder().getAtaque());
		}
		else {
			if (numeroRandom > 33 && numeroRandom < 67) {
			pj2.setPoder(poder4);
			System.out.println(pj2.getNombre() + " LANZÓ: " + pj2.getPoder().getNombre() + "\n" + pj2.getNombre() + "se defendió.");
			}
			else {
				if (numeroRandom > 66) {
				pj2.setPoder(poder6);
				System.out.println(pj2.getNombre() + " LANZÓ: " + pj2.getPoder().getNombre()  + "\nPoder de ataque: " + pj2.getPoder().getAtaque());
				}
			}
		}
	

		if (pj1.getvida() <= 0) {
			System.out.println( "\nVida de " + pj1.getNombre() + ": " + 0);
			System.out.println(pj1.getNombre() + " ha muerto.");

		}else {
				System.out.println( "\nVida de " + pj1.getNombre() + ": " + pj1.getvida());
				System.out.println("\n----------------------- ¡La batalla continua! -----------------------");
		}	
	}
	

	}
	System.out.println("----------------------- ¡¡FIN DE LA BATALLA!! -----------------------");
	System.out.println("\n"
			+ "                         #@@@@#.                  .%@@@@%.                        \n"
			+ "                      %@@%.                             #@@%                      \n"
			+ "                    #@@.                                  .@@#                    \n"
			+ "                  -@@:                                      :@@-                  \n"
			+ "                 #@%                                          %@#                 \n"
			+ "                *@*                                            #@*                \n"
			+ "               -@%                                              @@-               \n"
			+ "               #@.                                               @#               \n"
			+ "               @%  .@%                                      *@+  @@.              \n"
			+ "              .@*  *@+                                      .@@  +@:              \n"
			+ "              .@#  +@+                                      :@@  +@-              \n"
			+ "               @@  .@#                                      +@=  #@:              \n"
			+ "               *@:  #@-                                    .@@   @@               \n"
			+ "               .@@  .@#                                    =@-  *@+               \n"
			+ "                +@%  @@     -#@@@@@@.         @@@@@@#-     +@: =@%                \n"
			+ "                 @@%.@%  @@@@@@@@@@@@        @@@@@@@@@@@@  =@:%@@                 \n"
			+ "                  *@@@+ *@@@@@@@@@@@@:       @@@@@@@@@@@@@ :@@@+                  \n"
			+ "                    @@-  @@@@@@@@@@@@        *@@@@@@@@@@@: .@@                    \n"
			+ "      *@@@-         @@   -@@@@@@@@@*          =@@@@@@@@@*   *@.        =@@@@      \n"
			+ "     %@= +@@        @#    +@@@@@@@:     ::     .@@@@@@@#    +@=       @@- -@@     \n"
			+ "     @@   .@@       @#      -#@@-     #@#*@%     :%@%=      +@-      @@.   @@     \n"
			+ "    +@@    .@@%:    @@:              @@@#*@@@               @@    .%@@     @@#    \n"
			+ "  -@@=        *@@@* :@@.            =@@@#*@@@*             @@- #@@@#        -@@=  \n"
			+ " -@#             :@@@@@@@@%         @@@@#*@@@@         %@@@@@@@@.             *@+ \n"
			+ " :@@%-:+@@@+         +@@@@@@@@:     *@@@=-@@@@     .@@@@@@@@+         -@@@+:-#@@: \n"
			+ "   .*@@%+:=@@@@=         @@=**@@     #=    -@     @@%#=@@         -@@@@+.=%@@#.   \n"
			+ "              -%@@@-.    :@%*- @@                @@--**@=    .-@@@%=              \n"
			+ "                  =#@@%=  @@-# *@+=:.        .-==@# %:%@  =%@@%+                  \n"
			+ "                      =@@@@@.#. #.* @ @.+* @ @ +:+  % @@@@@=                      \n"
			+ "                         .@@ -* @@# @ % -= @ @ *@@.*- #@:                         \n"
			+ "                        #@@@  @**.* @:@-##:@.@ +:-+@  %@@%                        \n"
			+ "                     @@@@.@@-   @@* @ @ -= @ @ +@@   :@@:@@@@=                    \n"
			+ "                .%@@@#    .@#       =%@@@@@@@+       *@-    -@@@@-                \n"
			+ "       @@@@@@@@@@#.       .#@%                      #@%:        =@@@@@@@@@@:      \n"
			+ "      #@+              :@@@%#@@=                  =@@*#@@@-              :@@      \n"
			+ "       %@%         .+@@@+     =@@@+-          -+@@@+     +@@@*:         *@@       \n"
			+ "        .@@+     *@@#:           -*@@@@@@@@@@@@*-           .*@@%     -@@:        \n"
			+ "          @@    %@-                                            .@@:   %@-         \n"
			+ "          %@  .@@.                                               @@:  @@          \n"
			+ "          -@@@@%                                                  #@@@@+");
	}}
