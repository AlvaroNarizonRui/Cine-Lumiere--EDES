import java.io.File

class Cine {
    private val nFilas: Int = 10
    private val nAsientos: Int = 15
    private val nombreCine: String = "Cine Club Lumiere"
    private val cine: Array<Array<Int>> = Array(nFilas) { Array(nAsientos) { 0 } }

    // Al iniciar una instancia de la clase Cine se llama al método leerVentasDesdeArchivo()
    init {
        leerVentasDesdeArchivo()
    }

    // El método leerVentasDesdeArchivo() carga las ventas de entradas desde un archivo de texto
    fun leerVentasDesdeArchivo() {
        val archivo = File("entradasVendidas.txt")
        if (archivo.exists()) {
            archivo.forEachLine { linea ->
                val (fila, asiento) = linea.split(":")
                cine[fila.toInt() - 1][asiento.toInt() - 1] = 1
            }
        }
    }

    // El método guardarVentasEnArchivo() guarda las ventas de entradas en un archivo de texto
    fun guardarVentasEnArchivo() {
        val archivo = File("entradasVendidas.txt")
        archivo.bufferedWriter().use { writer ->
            cine.forEachIndexed { fila, asientos ->
                asientos.forEachIndexed { asiento, estado ->
                    if (estado == 1) {
                        writer.write("${fila + 1}:${asiento + 1}\n")
                    }
                }
            }
        }
    }

    // El método mostrarCineEnPantalla() muestra el estado actual del cine en la consola
    fun mostrarCineEnPantalla() {
        println("-------------------------")
        println(nombreCine)
        println("fila: número")
        println("asiento: número")
        println("-------------------------")
        cine.forEachIndexed { fila, asientos ->
            println("Fila ${fila + 1}:")
            asientos.forEach { asiento ->
                val simbolo = if (asiento == 0) "__" else "XX"
                print("$simbolo  ")
            }
            println()
        }
        println("-------------------------")
    }

    // El método venderEntrada() registra la venta de una entrada en una fila y asiento específico
    fun venderEntrada(fila: Int, asiento: Int): Boolean {
        if (fila < 1 || fila > nFilas || asiento < 1 || asiento > nAsientos) {
            println("La fila o el asiento no existen.")
            return false
        }

        val indiceFila = fila - 1
        val indiceAsiento = asiento - 1

        if (cine[indiceFila][indiceAsiento] == 1) {
            println("El asiento ya está ocupado.")
            return false
        }

        cine[indiceFila][indiceAsiento] = 1
        println("¡Entrada vendida correctamente!")
        return true
    }

    // El método devolverEntrada() marca una entrada previamente vendida como disponible nuevamente
    fun devolverEntrada(fila: Int, asiento: Int): Boolean {
        if (fila < 1 || fila > nFilas || asiento < 1 || asiento > nAsientos) {
            println("La fila o el asiento no existen.")
            return false
        }

        val indiceFila = fila - 1
        val indiceAsiento = asiento - 1

        if (cine[indiceFila][indiceAsiento] == 0) {
            println("El asiento no está ocupado.")
            return false
        }

        cine[indiceFila][indiceAsiento] = 0
        println("¡Entrada devuelta correctamente!")
        return true
    }

    // El método salir() guarda las ventas en el archivo y muestra un mensaje de despedida
    fun salir() {
        guardarVentasEnArchivo()
        println("Gracias por utilizar la aplicación del Cine Club Lumiere.")
    }
}