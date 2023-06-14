/* La clase Butaca tiene un constructor con los atributos fila y asiento
      que son la posición en el array de dos dimensiones donde estarán los
      asientos del cine */
data class Butaca(val fila: Int, val asiento: Int) {

    /* Esta clase solo tiene un método toString que devuelve la fila y el
      asiento */
    override fun toString(): String {
        return "$fila:$asiento"
    }
}