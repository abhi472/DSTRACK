package data_structures_algorithms.katas

/*
* The wave (known as the Mexican wave in the English-speaking world outside
* North America) is an example of metachronal rhythm achieved in a packed
* stadium when successive groups of spectators briefly stand, yell, and raise 
* their arms. Immediately upon stretching to full height, the spectator returns
* to the usual seated position. The result is a wave of standing spectators
* that travels through the crowd, even though individual spectators never move
* away from their seats. In many large arenas the crowd is seated in a 
* contiguous circuit all the way around the sport field, and so the wave is 
* able to travel continuously around the arena; in discontiguous seating 
* arrangements, the wave can instead reflect back and forth through the crowd.
* When the gap in seating is narrow, the wave can sometimes pass through it.
* Usually only one wave crest will be present at any given time in an arena,
* although simultaneous, counter-rotating waves have been produced.
*/

fun  main() {
val str = "krishna"
val n: Int = str.length
val newStr = mexicanWave(str, n)
println(newStr.contentToString())
}

fun mexicanWave(str: String, n:Int): Array<String> {


 var arr: Array<String> = emptyArray<String>()
 var charArray = str.toCharArray();
 var capCharArray: Array<Char> = emptyArray<Char>()

 for (c in charArray) {
    capCharArray += c.toUpperCase()
 }

    for(i in 0 .. n - 1) {
        var tempArr = str.toCharArray()
        tempArr[i] = capCharArray[i]
        arr += String(tempArr)

    }

    return arr

}