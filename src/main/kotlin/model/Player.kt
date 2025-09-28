package org.example.model

import kotlin.math.roundToInt

class Player(

    attack: Int,
    defence: Int,
    maxHealth: Int,
    currentHealth: Int,
    damageMin: Int,
    damageMax: Int,
    var healCount: Int = 4,

): Creature(attack, defence, maxHealth, currentHealth, damageMin, damageMax) {

    fun heal(): Boolean {
        if (healCount <= 0) {
            println("You cannot restore health\nRecoveries left: $healCount")
            return false
        }
        healCount -= 1
        val healAmount = (maxHealth * 0.3).roundToInt()
        currentHealth = (currentHealth + healAmount).coerceAtMost(maxHealth)
        println("You restore health for: $healAmount\nYour current health: $currentHealth\nRecoveries left: $healCount")
        return true
    }

}