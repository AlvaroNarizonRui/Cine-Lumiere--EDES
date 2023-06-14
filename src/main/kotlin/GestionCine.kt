class GestionCine {
    private val cine: Cine = Cine()

    // La función mostrarMenu muestra un menú donde el usuario puede elegir diferentes opciones
    fun mostrarMenu() {
        var opcion: Int
        do {
            println("1. Mostrar butacas")
            println("2. Comprar entrada")
            println("3. Devolver una entrada")
            println("4. Salir")
            print("Elige una opción: ")
            opcion = readLine()?.toIntOrNull() ?: 0
            when (opcion) {
                1 -> cine.mostrarCineEnPantalla()
                2 -> comprarEntrada()
                3 -> devolverEntrada()
                4 -> cine.salir()
                else -> println("Opción inválida. Inténtalo de nuevo.")
            }
        } while (opcion != 4)
    }

    // La función comprarEntrada permite al usuario comprar una entrada para una fila y asiento específicos
    fun comprarEntrada() {
        print("Ingrese el número de fila: ")
        val fila = readLine()?.toIntOrNull() ?: return

        print("Ingrese el número de asiento: ")
        val asiento = readLine()?.toIntOrNull() ?: return

        cine.venderEntrada(fila, asiento)
    }

    // La función devolverEntrada permite al usuario devolver una entrada previamente comprada
    fun devolverEntrada() {
        print("Ingrese el número de fila: ")
        val fila = readLine()?.toIntOrNull() ?: return

        print("Ingrese el número de asiento: ")
        val asiento = readLine()?.toIntOrNull() ?: return

        cine.devolverEntrada(fila, asiento)
    }
}