package org.example

import kotlin.system.exitProcess
import org.example.model.Player
import org.example.model.Monster

fun main() {

    while (true) {
        println("\n=== WELCOME TO PLAYERVERSUSMONSTERS ===")
        println("1 - Start game")
        println("2 - Exit")
        when (readln().trim()) {
            "1" -> startGame()
            "2" -> {
                println("Thank you for playing! Goodbye!")
                exitProcess(0)
            }
            else -> println("Invalid input, please try again.\n")
        }
    }

}

fun startGame() {

    val player1 = Player(30, 30, 100, 100, 2, 8)
    val monster1 = Monster(25, 30, 65, 65, 10, 15)

    println("\n--- Game Started! ---")
    println("Your stats: Attack: ${player1.attack}, Defence: ${player1.defence}, HP: ${player1.currentHealth}/${player1.maxHealth}, Damage: ${player1.damageMin}-${player1.damageMax}")
    println("Monster stats: Attack: ${monster1.attack}, Defence: ${monster1.defence}, HP: ${monster1.currentHealth}/${monster1.maxHealth}, Damage: ${monster1.damageMin}-${monster1.damageMax}")

    while (player1.isAlive() && monster1.isAlive()) {
        println("""
            
            --- New Turn ---
            Your turn! Choose action:
            1 - Attack
            2 - Heal
            3 - Skip turn
            4 - Exit
        """.trimIndent())

        val input = readln().trim()
        when (input) {
            "1" -> {
                if (player1.attackSuccess(monster1)) {
                    val damage = player1.generateDamage()
                    monster1.receiveDamage(damage)
                    println("You hit the monster for $damage damage.")
                } else {
                    println("Your attack missed!")
                }
            }
            "2" -> player1.heal()
            "3" -> println("You skipped your turn.")
            "4" -> {
                println("Where do you want to exit?")
                println("1 - Back to main menu")
                println("2 - Quit game")
                when (readln().trim()) {
                    "1" -> break
                    "2" -> {
                        println("Thank you for playing! Goodbye!")
                        exitProcess(0)
                    }
                    else -> println("Invalid input, continuing the game.")
                }
            }
            else -> {
                println("Invalid input, your turn is skipped.")
                continue
            }
        }

        if (!monster1.isAlive()) {
            println("Monster is dead! You win!")
            break
        }

        println("\nMonster's turn!")
        if (monster1.attackSuccess(player1)) {
            val damage = monster1.generateDamage()
            player1.receiveDamage(damage)
            println("Monster hit you for $damage damage!")
        } else {
            println("Monster's attack missed!")
        }

        if (!player1.isAlive()) {
            println("You died! Monster wins!")
            break
        }

        println("Current status: Player HP: ${player1.currentHealth}/${player1.maxHealth}, Monster HP: ${monster1.currentHealth}/${monster1.maxHealth}")
        println("----------------------------------------")
    }
}
