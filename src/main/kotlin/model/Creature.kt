package org.example.model

import kotlin.random.Random

abstract class Creature (

    var attack: Int,
    var defence: Int,
    var maxHealth: Int,
    var currentHealth: Int,
    var damageMin: Int,
    var damageMax: Int,

) {
    init {
        require(attack in 1..30) { "Attack must be between 1 and 30" }
        require(defence in 1..30) { "Defence must be between 1 and 30" }
        require(maxHealth > 0) { "maxHealth must be positive" }
        require(currentHealth in 0..maxHealth) { "currentHealth must be between 0 and maxHealth" }
        require(damageMin > 0) { "damageMin must be positive" }
        require(damageMax >= damageMin) { "damageMax must be greater or equal to damageMin" }
    }

    fun isAlive(): Boolean = currentHealth > 0


    fun receiveDamage(amount: Int){
        currentHealth -= amount
        if (currentHealth < 0) {
            currentHealth = 0
        }
    }

    fun generateDamage(): Int = Random.nextInt(damageMin, damageMax + 1)

    fun attackSuccess(defender: Creature): Boolean {

        val modifier = (this.attack - defender.defence + 1).coerceAtLeast(1)
        repeat(modifier) {
            val roll = Random.nextInt(1, 7)
            if (roll == 5 || roll == 6) {
                return true
            }
        }
        return false
    }

}