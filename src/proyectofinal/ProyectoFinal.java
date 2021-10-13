/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author VIVIANA
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    static String[] marca = new String[100]; //Marca del dipositivo
    static String[] modelo = new String[100]; //Modelo del dispositivo
    static String[] sO = new String[100]; //Sistema operativo del dispositivo
    static String[] capaciMem = new String[100]; //Capacidad de memoria del dispositivo 
    static String[] dimPant = new String[100]; //Dimension de la pantalla en pulgadas
    static String[] codigo = new String[100]; // Referencia del dispositivo
    static String[] estado = new String[100]; // estado del dispositivo

    public static void main(String[] args) {
        // TODO code application logic here

        String respuesta;
        int dis = 0;
        do {

            byte a = Byte.parseByte(JOptionPane.showInputDialog(null, "Digite la opcion que desea ejecutar:"
                    + "\n Digite 1 para registrar dispositivos."
                    + "\n Digite 2 para buscar un dispositivo a traves de su codigo."
                    + "\n Digite 3 para cambiar el estado de un dispositivo."
                    + "\n Digite 4 para cambiar el estado de ´en reparacion´ a ´disponible´ de un dispositivo."
                    + "\n Digite 5 para ver un listado con los dispositivos de un modelo especifico."
                    + "\n Digite 6 para ver un listado con los dispositivos de una marca especifica."
                    + "\n Digite 7 para buscar un dispositivo por su codigo para saber si esta ´disponible´, ´en reparacion´ o ´fuera de servicio´."
                    + "\n Digite 8 para saber el numero total de dispositivos disponibles, en reparacion y fuera de servicio."
                    + "\n Digite 9 para salir"));
            if (a == 1) {
                String tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo  de dispositivo a registrar (Smartphone/Tablet)").toUpperCase();
                marca[dis] = JOptionPane.showInputDialog(null, "Ingrese la marca del dispositivo");
                modelo[dis] = JOptionPane.showInputDialog(null, "Ingrese el modelo del dispositivo");
                sO[dis] = JOptionPane.showInputDialog(null, "Ingrese el Sistema Operativo del dispositivo");
                capaciMem[dis] = JOptionPane.showInputDialog(null, "Ingrese la capacidad de memoria del dispositivo");
                dimPant[dis] = JOptionPane.showInputDialog(null, "Ingrese la dimension de la pantalla en pulgadas");
                estado[dis] = "Disponible".toUpperCase();
                codigo[dis] = tipo.charAt(0) + "-" + marca[dis].substring(0, 2).toUpperCase() + (dis + 1);
                JOptionPane.showMessageDialog(null, "El dispositivo ha sido registrado con el codigo " + codigo[dis]);
                dis++;

            }

            if (a == 2) {
                String cO = JOptionPane.showInputDialog(null, "Ingrese el codigo del dispositivo que desea buscar").toUpperCase();
                int pos = encontrarPos(cO, codigo);
                if (pos == -1) {
                    JOptionPane.showMessageDialog(null, "El dispositivo buscado no esta registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "La marca del dispositivo es: " + marca[pos]
                            + "\n El modelo es: " + modelo[pos] + "\n El sistema operativo del dispositivo es: " + sO[pos]
                            + "\n La capacidad de memoria del dispositivo es: " + capaciMem[pos] + "\n La dimension de la pantalla en pulgadas es de: " + dimPant[pos]
                            + "\n El dispositivo esta " + estado[pos].toUpperCase());
                }
            }
            if (a == 3) {
                String cO = JOptionPane.showInputDialog(null, "Ingrese el codigo del dispositivo al cual desea cambiar el estado").toUpperCase();
                int pos = encontrarPos(cO, codigo);
                if (pos == -1) {
                    JOptionPane.showMessageDialog(null, "El dispositivo buscado no esta registrado");
                } else {

                    int eD = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite 1 para poner el dispositivo disponible. "
                            + "\nDigite 2 para poner el dispositivo en reparacion. "
                            + "\nDigite 3 para poner el dispositivo fuera de servicio."));
                    int pO = 0;
                    String oC = cO + 0; //Misma variable cO con un caracter mas, para que substring tome los valores correctos.
                    if ((cO.length()) - 1 == 6) {
                        pO = Integer.parseInt(oC.substring(4, 7));
                    }
                    if (cO.length() - 1 == 5) {
                        pO = Integer.parseInt(oC.substring(4, 6));
                    }
                    if ((cO.length()) - 1 == 4) {
                        pO = Integer.parseInt(cO.substring(4));
                    }
                    if (eD != 1 && eD != 2 && eD != 3) {
                        JOptionPane.showMessageDialog(null, "La opcion digitada no es valida!");
                    }
                    if (eD == 1) {
                        estado[(pO - 1)] = "disponible".toUpperCase();
                        JOptionPane.showMessageDialog(null, "El dispositivo " + cO + " ha entrado en modo disponible");
                    }
                    if (eD == 2) {
                        estado[(pO - 1)] = "en reparacion".toUpperCase();
                        JOptionPane.showMessageDialog(null, "El dispositivo " + cO + " ha entrado en reparacion");
                    }
                    if (eD == 3) {
                        estado[(pO - 1)] = "fuera de servicio".toUpperCase();
                        JOptionPane.showMessageDialog(null, "El dispositivo " + cO + " se encuentra fuera de servicio");
                    }

                }

            }
            if (a == 4) {
                String cO = JOptionPane.showInputDialog(null, "Ingrese el codigo del dispositivo al que desea poner disponible").toUpperCase();
                int pos = encontrarPos(cO, codigo);
                if (pos == -1) {
                    JOptionPane.showMessageDialog(null, "El dispositivo buscado no esta registrado");
                } else {
                    estado[pos] = "Disponible".toUpperCase();
                    JOptionPane.showMessageDialog(null, "El dispositivo " + cO.toUpperCase() + " ahora esta disponible!");
                }
            }
            if (a == 5) {
                String mode = JOptionPane.showInputDialog(null, "Ingrese el modelo del dispositivo a buscar");
                JOptionPane.showMessageDialog(null, caraMod(mode));
            }
            if (a == 6) {
                String marc = JOptionPane.showInputDialog(null, "Ingrese la marca del dispositivo a buscar");
                JOptionPane.showMessageDialog(null, mar(marc));
            }
            if (a == 7) {
                String cO = JOptionPane.showInputDialog(null, "Ingrese el codigo del dispositivo").toUpperCase();
                int pos = encontrarPos(cO, codigo);
                if (pos == -1) {
                    JOptionPane.showMessageDialog(null, "El dispositivo buscado no esta registrado");
                } else {
                    JOptionPane.showMessageDialog(null, "El dispositivo se encuentra " + estado[pos]);
                }
            }
            if (a == 8) {
                JOptionPane.showMessageDialog(null, " Hay " + contarDispo(estado) + " dispositivo(s) disponibles."
                        + "\n Hay " + contarRepara(estado) + " dispositivo(s) en reparacion." + "\n Hay " + contarServicio(estado) + " dispositivo(s) fuera de servicio");

            }
            if (a == 9) {
                System.exit(0);
            }

            respuesta = JOptionPane.showInputDialog(null, "¿Desea continuar en la "
                    + "aplicacion? SI/NO?");
        } while (respuesta.equalsIgnoreCase("Si"));
    }

    //METODOS
    /**
     * Metodo que encuentra la posicion de un dispositivo respecto aun arreglo a
     * traves de su codigo
     *
     * @param cO codigo a identificar
     * @param codigo arreglo a evaluar
     * @return la posicion donde esta el codigo, de lo contrario retorna -1
     */
    public static int encontrarPos(String cO, String[] codigo) {
        for (int i = 0; i < codigo.length; i++) {
            if (codigo[i] != null) {
                if (codigo[i].equals(cO.toUpperCase())) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Metodo que encuentra las caracteristicas de un dispositivo por su modelo
     *
     * @param mode a identificar
     * @return mensaje
     */
    public static String caraMod(String mode) {
        String mensaje = "";
        for (int i = 0; i < modelo.length; i++) {
            if (modelo[i] != null) {
                if (mode.equals(modelo[i])) {
                    mensaje += "Codigo: " + codigo[i] + "\nMemoria: " + capaciMem[i] + "\nPantalla en pulgadas: " + dimPant[i]
                            + "\nEl telefono se encuentra " + estado[i] + "\n-----------------------------\n";
                }
            }
        }
        return mensaje;
    }

    /**
     * Metodo que encuentra las caracteristicas de un dispositivo por su modelo
     *
     * @param marc a identificar
     * @return mensaje
     */
    public static String mar(String marc) {
        String mensaje = "";
        for (int i = 0; i < marca.length; i++) {
            if (marca[i] != null) {
                if (marc.equals(marca[i])) {
                    mensaje += "Codigo: " + codigo[i] + "\nSistema operativo: " + sO[i] + "\nPantalla en pulgadas: " + dimPant[i]
                            + "\nEl telefono se encuentra " + estado[i] + "\nLa capacidad de memoria es de: " + capaciMem[i] + "\n-----------------------------\n";
                }
            }
        }
        return mensaje;
    }

    /**
     * cuenta los dispositivos disponibles en un arreglo
     *
     * @param estado que contiene los datos
     * @return cantidad de dispositivos disponibles
     */
    public static int contarDispo(String[] estado) {
        int con = 0;
        for (int i = 0; i < estado.length; i++) {
            if ("disponible".toUpperCase().equals(estado[i])) {
                con++;
            }
        }
        return con;
    }

    /**
     * cuenta los dispositivos que estan en reparacion de un arreglo
     *
     * @param estado que contiene los datos
     * @return cantidad de dispositivos en reparacion
     */
    public static int contarRepara(String[] estado) {
        int con = 0;
        for (int i = 0; i < estado.length; i++) {
            if ("en reparacion".toUpperCase().equals(estado[i])) {
                con++;
            }
        }
        return con;
    }

    /**
     * cuenta los dispositivos que estan fuera de servicio de un arreglo
     *
     * @param estado que contiene los datos
     * @return cantidad de dispositivos en reparacion
     */
    public static int contarServicio(String[] estado) {
        int con = 0;
        for (int i = 0; i < estado.length; i++) {
            if ("fuera de servicio".toUpperCase().equals(estado[i])) {
                con++;
            }
        }
        return con;
    }
}
