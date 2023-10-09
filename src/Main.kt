fun main (args: Array<String>) {
    val player: Player = Player(name = "Hero", attack = 4, defense = 3, maxHealth = 30, minDamage = 1, maxDamage = 10)
    val monster: Monster = Monster(name = "Undead", attack = 3, defense = 4, maxHealth = 60, minDamage = 1, maxDamage = 6)

    println("Game beginning.")
    println("Player characteristics: name ${player.creatureName}, " +
            "attack ${player.creatureAttack}, " +
            "defense ${player.creatureDefense}, " +
            "maximum health ${player.creatureMaxHealth}, " +
            "damage from ${player.creatureMinDamage} to ${player.creatureMaxDamage}.")
    println("Monster characteristics: name ${monster.creatureName}, " +
            "attack ${monster.creatureAttack}, " +
            "defense ${monster.creatureDefense}, " +
            "maximum health ${monster.creatureMaxHealth}, " +
            "damage from ${monster.creatureMinDamage} to ${monster.creatureMaxDamage}.\n")

    while (monster.creatureIsAliveState && player.creatureIsAliveState) {
        if (player.playerHealCounter > 0 && player.creatureCurrentHealth < player.creatureMaxHealth * 0.7) {
                playerHealing(player)
        } else {
            playerAttack(player, monster)
        }

        monsterAttack(monster, player)
    }
}

fun playerAttack (player: Player, creature: Creature) {
    println("The player attacks!")
    creature.takeDamage(player.dealDamage(creature.creatureDefense))
    println()
}

fun monsterAttack (monster: Monster, creature: Creature) {
    println("The monster attacks!")
    creature.takeDamage(monster.dealDamage(creature.creatureDefense))
    println()
}

fun playerHealing(player: Player) {
    println("The player is healing.")
    player.heal()
    println()
}