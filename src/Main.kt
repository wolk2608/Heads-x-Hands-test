fun main (args: Array<String>) {
    val player: Player = Player(name = "Hero", attack = 4, defense = 3, maxHealth = 30, minDamage = 1, maxDamage = 10)
    val monster: Monster = Monster(name = "Undead", attack = 3, defense = 4, maxHealth = 60, minDamage = 1, maxDamage = 6)

    println("Game beginning.")
    println("Player characteristics: name ${player.getCreatureName()}, " +
            "attack ${player.getCreatureAttack()}, " +
            "defense ${player.getCreatureDefense()}, " +
            "maximum health ${player.getCreatureMaxHealth()}, " +
            "damage from ${player.getCreatureMinDamage()} to ${player.getCreatureMaxDamage()}.")
    println("Monster characteristics: name ${monster.getCreatureName()}, " +
            "attack ${monster.getCreatureAttack()}, " +
            "defense ${monster.getCreatureDefense()}, " +
            "maximum health ${monster.getCreatureMaxHealth()}, " +
            "damage from ${monster.getCreatureMinDamage()} to ${monster.getCreatureMaxDamage()}.\n")

    while (monster.getCreatureIsAliveState() && player.getCreatureIsAliveState()) {
        if (player.getHealCounter() > 0) {
            if (player.getCreatureCurrentHealth() < player.getCreatureMaxHealth() * 0.7) {
                playerHealing(player)
            } else {
                playerAttack(player, monster)
            }
        } else {
            playerAttack(player, monster)
        }

        monsterAttack(monster, player)
    }
}

fun playerAttack (player: Player, creature: Creature) {
    print("The player attacks!\n")
    creature.takeDamage(player.dealDamage(creature.getCreatureDefense()))
    println()
}

fun monsterAttack (monster: Monster, creature: Creature) {
    print("The monster attacks!\n")
    creature.takeDamage(monster.dealDamage(creature.getCreatureDefense()))
    println()
}

fun playerHealing(player: Player) {
    print("The player is healing.\n")
    player.heal()
    println()
}