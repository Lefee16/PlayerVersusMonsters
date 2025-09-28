package org.example.model

class Monster(

    attack: Int,
    defence: Int,
    maxHealth: Int,
    currentHealth: Int,
    damageMin: Int,
    damageMax: Int,

): Creature(attack, defence, maxHealth, currentHealth, damageMin, damageMax)