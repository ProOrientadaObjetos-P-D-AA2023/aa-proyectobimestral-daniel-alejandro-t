package paquete01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Importamos todos los paquetes que contienen las clases
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

import archivos.*;

/**
 *
 * @author daniel-alejandro-t 
 */
public class Ejecutor {

    public static void main(String[] args) {
        // Textos de menu de opciones
        String menuPrincipal = "Menú de opciones \n 1. CRUD Propietarios \n 2. CRUD Barrios \n 3. CRUD Ciudades \n 4. CRUD Constructoras \n 5. CRUD Casas \n 6. CRUD Departamentos \n 7. Salir";
        String menuCRUD = "Menú de opciones \n 1. Crear \n 2. Leer \n 3. Actualizar \n 4. Eliminar \n 5. Salir";

        // Creamos una lista para todos los objetos
        // de tipo Propietario, Barrio, Ciudad, Constructora y Casa
        List<Propietario> listaPropietarios;
        //  FIXME List<Propietario> listaPropietarios;
        List<Barrio> listaBarrios;
        List<Ciudad> listaCiudades;
        List<Constructora> listaConstructoras;
        List<Casa> listaCasas;
        List<Departamento> listaDepartamentos;

        // Inicializamos las listas
        // Instanciamos los objetos de tipo ArchivoLectura
        String rutaArchivo = "AdministrarInmobiliaria/datos/";

        // Si el sistema operativo en el que se ejecuta el programa es Windows
        // rutaArchivo cambia los slash invertidos por slash normales
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            rutaArchivo = rutaArchivo.replace("/", "\\");
        }
        
        // Instanciamos los objetos Fichero para las operaciones de lectura y escritura con los archivos
        FicheroPropietario archivoPropietarios = new FicheroPropietario(rutaArchivo + "propietarios.txt");
        FicheroBarrio archivoBarrios = new FicheroBarrio(rutaArchivo + "barrios.txt");
        FicheroCiudad archivoCiudades = new FicheroCiudad(rutaArchivo + "ciudades.txt");
        FicheroDepartamento archivoDepartamento = new FicheroDepartamento(rutaArchivo + "departamentos.txt");


        // Usando el método getListaPropietarios() de la clase FicheroPropietario cargamos los datos
        //  del archivo al programa usando la instancia del objeto lecturaPropietarios
        listaPropietarios = archivoPropietarios.getListaPropietarios();
        listaBarrios = archivoBarrios.getListaBarrios();
        listaCiudades = archivoCiudades.getListaBarrios();
        listaDepartamentos = archivoDepartamento.getListaDepartamentos();

        // Creamos un objeto de tipo Scanner para leer la opción ingresada por el usuario
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 7
        do {
            // Imprimimos el consola el menú de opciones
            // Que nos permite hacer un CRUD de propietarios; barrio; ciudades; constructoras; casas; departamentos
            System.out.println(menuPrincipal);

            // Leemos la opción ingresada por el usuario
            opcion = entrada.nextInt();

            // Creamos un switch para ejecutar el CRUD correspondiente
            switch (opcion) {
                case 1:     // Propietarios
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 1
                    while (opcion != 5) {
                        // Imprimimos el consola el menú de opciones
                        // Que nos permite hacer un CRUD de propietarios
                        System.out.println(menuCRUD);

                        // Leemos la opción ingresada por el usuario
                        opcion = entrada.nextInt();

                        // Creamos un switch para ejecutar el CRUD correspondiente
                        switch (opcion) {
                            case 1:     // Crear
                                String nombres,
                                 apellidos,
                                 identificacion;

                                // Crear un objeto de tipo Propietario
                                do {
                                    System.out.println("Ingrese los nombres del propietario");
                                    nombres = entrada.nextLine();
                                } while (nombres.isEmpty());

                                do {
                                    System.out.println("Ingrese los apellidos del propietario");
                                    apellidos = entrada.nextLine();
                                } while (apellidos.isEmpty());

                                do {
                                    System.out.println("Ingrese la identificación del propietario");
                                    identificacion = entrada.nextLine();
                                } while (identificacion.isEmpty());

                                listaPropietarios.add(new Propietario(nombres, apellidos, identificacion));

                                break;

                            case 2:     // Leer
                                // Usando el método setLeerLista() de la clase Ejecutor
                                // imprimimos en consola la lista de propietarios
                                setLeerLista(listaPropietarios);

                                break;

                            case 3:     // Actualizar
                                if (listaPropietarios == null) {
                                    System.out.println("No hay propietarios registrados para actualizar");
                                    break;
                                } else {
                                    String identificador, nombresUpdate, apellidosUpdate, identificacionUpdate;

                                    // Ingrese el identificador del propietario que desea actualizar
                                    System.out.println("Ingrese el identificador del propietario que desea actualizar");
                                    setLeerLista(listaPropietarios);
                                    do {
                                        identificador = entrada.nextLine();
                                    } while (identificador.isEmpty());

                                    // Creamos un objeto de tipo Propietario
                                    System.out.println("Ingrese los datos del nuevo propietario");

                                    do {
                                        System.out.println("Ingrese los nombres del propietario");
                                        nombresUpdate = entrada.nextLine();
                                    } while (nombresUpdate.isEmpty());

                                    do {
                                        System.out.println("Ingrese los apellidos del propietario");
                                        apellidosUpdate = entrada.nextLine();
                                    } while (apellidosUpdate.isEmpty());

                                    do {
                                        System.out.println("Ingrese la identificación del propietario");
                                        identificacionUpdate = entrada.nextLine();
                                    } while (identificacionUpdate.isEmpty());

                                    // Usando el método setActualizarObjeto() de la clase Ejecutor
                                    // actualizamos el objeto de tipo Propietario
                                    setActualizarObjeto(new Propietario(nombresUpdate, apellidosUpdate, identificacionUpdate), identificador, listaPropietarios);
                                }
                                break;

                            case 4:     // Eliminar
                                if (listaPropietarios == null) {
                                    System.out.println("No hay propietarios registrados para eliminar");
                                } else {
                                    // Ingrese el identificador del propietario que desea eliminar
                                    System.out.println("Ingrese el índice del propietario que desea eliminar");
                                    setLeerLista(listaPropietarios);
                                    int identificadorEliminar;

                                    do {
                                        identificadorEliminar = entrada.nextInt();
                                    } while (identificadorEliminar < 0 || identificadorEliminar > listaPropietarios.size());

                                    // Usando el método setEliminarObjeto() de la clase Ejecutor
                                    // eliminamos el objeto de tipo Propietario
                                    listaPropietarios.remove(identificadorEliminar);
                                }
                                break;
                            case 5:     // Salir
                                opcion = 5;
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }

                    }

                case 2:     // Barrios
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 2

                    // Imprimimos el consola el menú de opciones
                    // Que nos permite hacer un CRUD de propietarios
                    while (opcion != 5) {
                        System.out.println(menuCRUD);

                        // Leemos la opción ingresada por el usuario
                        int opcion2 = entrada.nextInt();

                        // Creamos un switch para ejecutar el CRUD correspondiente
                        switch (opcion2) {
                            case 1:     // Crear
                                String nombreBarrio,
                                 referencia;

                                // Crear un objeto de tipo Barrio
                                do {
                                    System.out.println("Ingrese el nombre Del barrio");
                                    nombreBarrio = entrada.nextLine();
                                } while (nombreBarrio.isEmpty());

                                do {
                                    System.out.println("Ingrese la referencia");
                                    referencia = entrada.nextLine();
                                } while (referencia.isEmpty());

                                listaBarrios.add(new Barrio(nombreBarrio, referencia));

                                break;

                            case 2:     // Leer
                                // Usando el método setLeerLista() de la clase Ejecutor
                                // imprimimos en consola la lista de Barrio
                                setLeerLista(listaBarrios);

                                break;

                            case 3:     // Actualizar
                                if (listaBarrios == null) {
                                    System.out.println("No hay barrios registrados para actualizar");

                                } else {
                                    String  nombresU, referencia1;
                                    int identificadorB;
                                    boolean bandera = true;

                                    // Ingrese el identificador del Barrio que desea actualizar
                                    
                                     System.out.println("-------------------------------");
                                    setLeerLista(listaBarrios);
                                    System.out.println("---------------------------------");
                                    System.out.println("Ingrese el identificador del barrio que desea actualizar");
                                    do {
                                        identificadorB = entrada.nextInt();
                                    } while (identificadorB < 0 || identificadorB > listaBarrios.size());

                                    // Creamos un objeto de tipo barrio
                                    System.out.println("Ingrese los datos del nuevo del barrio");

                                    do {
                                        System.out.println("Ingrese el nombre del barrio");
                                        nombresU = entrada.nextLine();
                                    } while (nombresU.isEmpty());

                                    do {
                                        System.out.println("Ingrese la referencia");
                                        referencia1 = entrada.nextLine();
                                    } while (referencia1.isEmpty());

                                    // Usando el método setActualizarObjeto() de la clase Ejecutor
                                    // actualizamos el objeto de tipo Barrio
                                    listaBarrios.set(identificadorB, new Barrio(nombresU,referencia1));
                                }
                                break;
                            case 4:     // Eliminar
                                if (listaPropietarios == null) {
                                    System.out.println("No hay Barrios registrados para eliminar");
                                } else {
                                    // Ingrese el identificador del barrio que desea eliminar que desea eliminar
                                    System.out.println("Ingrese el índice del barrio que desea eliminar");
                                    setLeerLista(listaBarrios);
                                    int identificadorEliminar;

                                    do {
                                        identificadorEliminar = entrada.nextInt();
                                    } while (identificadorEliminar < 0 || identificadorEliminar > listaBarrios.size());

                                    // Usando el método setEliminarObjeto() de la clase Ejecutor
                                    // eliminamos el objeto de tipo Propietario
                                    listaBarrios.remove(identificadorEliminar);
                                }
                                break;
                            case 5:     // Salir
                                opcion = 5;
                                
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }

                    }

                    break;
                case 3:     // Ciudades
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 3
                    while (opcion != 5) {
                        // Imprimimos el consola el menú de opciones
                        // Que nos permite hacer un CRUD de propietarios
                        System.out.println(menuCRUD);

                        // Leemos la opción ingresada por el usuario
                        int opcion3 = entrada.nextInt();
                        switch (opcion3) {
                            case 1:     // Crear
                                String nombreCiudad,
                                 nombreProvincia;

                                // Crear un objeto de tipo Propietario
                                do {
                                    System.out.println("Ingrese el nombre de la ciudad");
                                    nombreCiudad = entrada.nextLine();
                                } while (nombreCiudad.isEmpty());

                                do {
                                    System.out.println("Ingrese el nombre de la Provincia");
                                    nombreProvincia = entrada.nextLine();
                                } while (nombreProvincia.isEmpty());

                                listaCiudades.add(new Ciudad(nombreCiudad, nombreProvincia));
                                break;

                            case 2: //Leer
                                // Usando el método setLeerLista() de la clase Ejecutor
                                // imprimimos en consola la lista de propietarios
                                setLeerLista(listaCiudades);

                                break;
                            case 3:  //Actualizar    
                                if (listaCiudades == null) {
                                    System.out.println("No hay ciudades registrados para actualizar");

                                } else {
                                    String nombreCiu2, nombreProv2;
                                    int identificadorB;

                                    // Ingrese el identificador del propietario que desea actualizar
                                    System.out.println("-------------------------------");
                                    setLeerLista(listaCiudades);
                                    System.out.println("---------------------------------");
                                    System.out.println("Ingrese el identificador de la ciudad que desea actualizar");
                                    do {
                                        identificadorB = entrada.nextInt();
                                    } while (identificadorB < 0 || identificadorB > listaCiudades.size());

                                    // Creamos un objeto de tipo barrio
                                    System.out.println("Ingrese los datos del nuevo de la nueva ciudad");

                                    do {
                                        System.out.println("Ingrese el nombre de la ciudad");
                                        nombreCiu2 = entrada.nextLine();
                                    } while (nombreCiu2.isEmpty());

                                    do {
                                        System.out.println("Ingrese el nombre de la provincia");
                                        nombreProv2 = entrada.nextLine();
                                    } while (nombreProv2.isEmpty());

                                    // Usando el método setActualizarObjeto() de la clase Ejecutor
                                    // actualizamos el objeto de tipo Propietario
                                    listaCiudades.set(identificadorB, new Ciudad(nombreCiu2, nombreProv2));
                                }
                                break;
                                
                            case 4:     // Eliminar
                                if (listaCiudades == null) {
                                    System.out.println("No hay ciudades registrados para eliminar");
                                } else {
                                    // Ingrese el identificador del barrio que desea eliminar que desea eliminar
                                    System.out.println("Ingrese el índice de la ciudad que desea eliminar");
                                    setLeerLista(listaCiudades);
                                    int identificadorEliminar;

                                    do {
                                        identificadorEliminar = entrada.nextInt();
                                    } while (identificadorEliminar < 0 || identificadorEliminar > listaCiudades.size());

                                    // Usando el método setEliminarObjeto() de la clase Ejecutor
                                    // eliminamos el objeto de tipo Propietario
                                    listaCiudades.remove(identificadorEliminar);
                                }
                                break;
                            case 5:     // Salir
                                opcion = 5;

                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }

                    }
                case 4:     // Constructoras
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 4

                    break;
                case 5:     // Casas
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 5

                    break;
                case 6:     // Departamentos
                    // Creamos un ciclo que se repite mientras la opción ingresada sea diferente de 6
                    while (opcion != 5) {
                        // Imprimimos el consola el menú de opciones
                        // Que nos permite hacer un CRUD de propietarios
                        System.out.println(menuCRUD);

                        // Leemos la opción ingresada por el usuario
                        opcion = entrada.nextInt();

                        // Creamos un switch para ejecutar el CRUD correspondiente
                        switch (opcion) {
                            case 1:     // Crear
                                String nombreEdifici, ubicacionIntern, identificacionPropietari, nombreBarri, nombreCiuda, idConstructor;
                                double valorAlicuotaMensua, precioMetroCuadrad, numMetrosCuadrado;
                                int numCuarto;

                                // Crear un objeto de tipo Propietario
                                do {
                                    System.out.println("Ingrese el nombre del edificio");
                                    nombreEdifici = entrada.nextLine();
                                } while (nombreEdifici.isEmpty());

                                do {
                                    System.out.println("Ingrese la ubicacion interna");
                                    ubicacionIntern = entrada.nextLine();
                                } while (ubicacionIntern.isEmpty());

                                do {
                                    System.out.println("Ingrese la identificación del propietario");
                                    identificacionPropietari = entrada.nextLine();
                                } while (identificacionPropietari.isEmpty());
                                
                                do {
                                    System.out.println("Ingrese el nombre del Barrio");
                                    nombreBarri = entrada.nextLine();
                                } while (nombreBarri.isEmpty());
                                
                                do {
                                    System.out.println("Ingrese el nombre de la ciudad");
                                    nombreCiuda = entrada.nextLine();
                                } while (nombreCiuda.isEmpty());
                                
                                do {
                                    System.out.println("Ingrese el ID de la constructora");
                                    idConstructor = entrada.nextLine();
                                } while (idConstructor.isEmpty());
                                
                                do {
                                    System.out.println("Ingrese el valor de la alicuota mensual");
                                    while (!entrada.hasNextDouble()) {
                                        entrada.next(); // Descartar la entrada no válida
                                    }
                                    valorAlicuotaMensua = entrada.nextDouble();
                                } while (valorAlicuotaMensua <= 0);
                                
                                do {
                                    System.out.println("Ingrese el precio por metros cuadrados");
                                    while (!entrada.hasNextDouble()) {
                                        entrada.next(); // Descartar la entrada no válida
                                    }
                                    precioMetroCuadrad = entrada.nextDouble();
                                } while (precioMetroCuadrad <= 0);
                                
                                do {
                                    System.out.println("Ingrese el numero de los metros cuadrados");
                                    while (!entrada.hasNextDouble()) {
                                        entrada.next(); // Descartar la entrada no válida
                                    }
                                    numMetrosCuadrado = entrada.nextDouble();
                                } while (numMetrosCuadrado <= 0);
                                
                                do {
                                    System.out.println("Ingrese el numero de cuartos");
                                    while (!entrada.hasNextInt()) {
                                        entrada.next(); // Descartar la entrada no válida
                                    }
                                    numCuarto = entrada.nextInt();
                                } while (numCuarto <= 0);
                                
                                listaDepartamentos.add(new Departamento(valorAlicuotaMensua, nombreEdifici, ubicacionIntern, precioMetroCuadrad, numMetrosCuadrado,
                                numCuarto, identificacionPropietari, nombreBarri, nombreCiuda, idConstructor));

                                break;

                            case 2:     // Leer
                                // Usando el método setLeerLista() de la clase Ejecutor
                                // imprimimos en consola la lista de departamentos
                                setLeerLista(listaDepartamentos);

                                break;

                            case 3:     // Actualizar
                                if (listaPropietarios == null) {
                                    System.out.println("No hay departamentos registrados para actualizar");
                                    break;
                                } else {
                                    String identificador, nombreEUpdate, UbiUpdate, identificacionPropUpdate, barriUpdate, ciuUpdate, idConsUpdate;
                                    double valorAlicuUpdate, precioMeCuaUpdate,numMetCuaUpdate;
                                    int numCuarUpdate;

                                    // Ingrese el identificador del propietario al departamento que desea actualizar
                                    System.out.println("Ingrese el identificador del propietario que desea actualizar");
                                    setLeerLista(listaDepartamentos);
                                    do {
                                        identificador = entrada.nextLine();
                                    } while (identificador.isEmpty());

                                    // Creamos un objeto de tipo Departamento
                                    System.out.println("Ingrese los datos del nuevo departamento");

                                    do {
                                        System.out.println("Ingrese el nombre del edificio");
                                        nombreEUpdate = entrada.nextLine();
                                    } while (nombreEUpdate.isEmpty());

                                    do {
                                        System.out.println("Ingrese la ubicacion interna en el departamento");
                                        UbiUpdate = entrada.nextLine();
                                    } while (UbiUpdate.isEmpty());

                                    do {
                                        System.out.println("Ingrese la identificación del propietario");
                                        identificacionPropUpdate = entrada.nextLine();
                                    } while (identificacionPropUpdate.isEmpty());
                                    
                                    do {
                                    System.out.println("Ingrese el nombre del Barrio");
                                    barriUpdate = entrada.nextLine();
                                } while (barriUpdate.isEmpty());
                                
                                do {
                                    System.out.println("Ingrese el nombre de la ciudad");
                                    ciuUpdate = entrada.nextLine();
                                } while (ciuUpdate.isEmpty());
                                
                                do {
                                    System.out.println("Ingrese el ID de la constructora");
                                    idConsUpdate = entrada.nextLine();
                                } while (idConsUpdate.isEmpty());
                                
                                do {
                                    System.out.println("Ingrese el valor de la alicuota mensual");
                                    while (!entrada.hasNextDouble()) {
                                        entrada.next(); // Descartar la entrada no válida
                                    }
                                    valorAlicuUpdate = entrada.nextDouble();
                                } while (valorAlicuUpdate <= 0);
                                
                                do {
                                    System.out.println("Ingrese el precio por metros cuadrados");
                                    while (!entrada.hasNextDouble()) {
                                        entrada.next(); // Descartar la entrada no válida
                                    }
                                    precioMeCuaUpdate = entrada.nextDouble();
                                } while (precioMeCuaUpdate <= 0);
                                
                                do {
                                    System.out.println("Ingrese el numero de los metros cuadrados");
                                    while (!entrada.hasNextDouble()) {
                                        entrada.next(); // Descartar la entrada no válida
                                    }
                                    numMetCuaUpdate = entrada.nextDouble();
                                } while (numMetCuaUpdate <= 0);
                                
                                do {
                                    System.out.println("Ingrese el numero de cuartos");
                                    while (!entrada.hasNextInt()) {
                                        entrada.next(); // Descartar la entrada no válida
                                    }
                                    numCuarUpdate = entrada.nextInt();
                                } while (numCuarUpdate <= 0);
                                
                                    // Usando el método setActualizarObjeto() de la clase Ejecutor
                                    // actualizamos el objeto de tipo Deparamento
                                    setActualizarObjeto(new Departamento(valorAlicuUpdate, nombreEUpdate, UbiUpdate, 
                         precioMeCuaUpdate, numMetCuaUpdate,numCuarUpdate, identificacionPropUpdate, 
                              barriUpdate, ciuUpdate, idConsUpdate), identificador, listaDepartamentos);
                                }
                                break;

                            case 4:     // Eliminar
                                if (listaPropietarios == null) {
                                    System.out.println("No hay departamentos registrados para eliminar");
                                } else {
                                    // Ingrese el identificador del propietario que desea eliminar
                                    System.out.println("Ingrese el índice del departamento que desea eliminar");
                                    setLeerLista(listaDepartamentos);
                                    int identificadorEliminar;

                                    do {
                                        identificadorEliminar = entrada.nextInt();
                                    } while (identificadorEliminar < 0 || identificadorEliminar > listaDepartamentos.size());

                                    // Usando el método setEliminarObjeto() de la clase Ejecutor
                                    // eliminamos el objeto de tipo Propietario
                                    listaDepartamentos.remove(identificadorEliminar);
                                }
                                break;
                            case 5:     // Salir
                                opcion = 5;
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                case 7:     // Salir
                    // Al salir del programa, volcamos los datos de las listas hacia los archivos
                    archivoPropietarios.setVolcarDatosAlArchivo(listaPropietarios);
                    archivoBarrios.setVolcarDatosAlArchivo(listaBarrios);
                    archivoCiudades.setVolcarDatosAlArchivo(listaCiudades);
                    archivoDepartamento.setVolcarDatosAlArchivo(listaDepartamentos);
                    System.out.println("Gracias por usar el programa.");

                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }            
         
        } while (opcion != 7);

        // Cerramos el objeto de tipo Scanner
        entrada.close();

    }
    // Métodos CRUD
    // No se crea el método Create ya que sería redundante
    // al poder invocar al método add de las listas

    // Read
    public static void setLeerLista(List listaObjetos) {
        if (listaObjetos == null) {
            System.out.println("No hay datos para mostrar");
        } else {
            for (int i = 0; i < listaObjetos.size(); i++) {
                System.out.println("Indice:  " + i + listaObjetos.get(i).toString());
            }
        }
    }

    // Update
    public static void setActualizarObjeto(Object objeto, String identificador, List listaObjetos) {
        // El identificador es en propietario:identificación, barrio:nombre, ciudad:nombre, constructora:id

        // Si el objeto es de tipo Propietario
        if (objeto instanceof Propietario) {
            // Remplazamos de la lista de propietarios el objeto que tenga la misma identificación
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Propietario) listaObjetos.get(i)).getIdentificacion().equalsIgnoreCase(identificador)) {
                    // Remplaza el objeto por el que se encuentra en la misma ubicación
                    listaObjetos.set(i, objeto);
                }
            }
        } else if (objeto instanceof Barrio) {
            // Remplazamos de la lista de barrios el objeto que tenga el mismo nombre
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Barrio) listaObjetos.get(i)).getNombreBarrio().equalsIgnoreCase(identificador)) {
                    listaObjetos.set(i, objeto);
                }
            }
        } else if (objeto instanceof Ciudad) {
            // Remplazamos de la lista de ciudades el objeto que tenga el mismo nombre
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Ciudad) listaObjetos.get(i)).getNombreCiudad().equalsIgnoreCase(identificador)) {
                    listaObjetos.set(i, objeto);
                }
            }
        } else if (objeto instanceof Constructora) {
            // Remplazamos de la lista de constructoras el objeto que tenga el mismo id
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Constructora) listaObjetos.get(i)).getIdConstructora().equalsIgnoreCase(identificador)) {
                    listaObjetos.set(i, objeto);
                }
            }
        } else if (objeto instanceof Casa) {
            // Remplazamos de la lista de casas el objeto que tenga el mismo id
            // que el identificador ingresado por el usuario
            for (int i = 0; i < listaObjetos.size(); i++) {
                if (((Casa) listaObjetos.get(i)).getNumCasa().equalsIgnoreCase(identificador)) {
                    listaObjetos.set(i, objeto);
                }
            }
        } else {
            System.out.println("El objeto no es de tipo Propietario, Barrio, Ciudad, Constructora o Casa");
        }

    }

    // Delete
    public static void setBorrarObjeto(Object object, List listaObjetos) {
        if (object instanceof Propietario) {
            listaObjetos.remove(object);
        } else if (object instanceof Barrio) {
            listaObjetos.remove(object);
        } else if (object instanceof Ciudad) {
            listaObjetos.remove(object);
        } else if (object instanceof Constructora) {
            listaObjetos.remove(object);
        } else if (object instanceof Casa) {
            listaObjetos.remove(object);
        } else {
            System.out.println("El objeto no es de tipo Propietario, Barrio, Ciudad, Constructora o Casa");
        }
    }

}
