package example.kotlin.textadventure


fun main(args: Array<String>) {

    val locations = readLocationInfo()
    var loc = 64; // Initial location

    while (true) {
        val location = locations[loc] ?: Location(0,
                                                  "Sorry, something went wrong, so the game will terminate")

        // Showing the description for the current location
        println(location.description)

        // The app ends
        if(location.locationID == 0) {
            break
        }

        print("Available exits are: ")
        location.exits.keys.forEach {
            print("$it, ")
        }

        val direction = readLine()?.toUpperCase() ?: "Z"
        if(location.exits.containsKey(direction)) {
            loc = location.exits[direction]!!
        }
        else {
            println("You can not go in that direction, please, choose another one")
        }
    }
}