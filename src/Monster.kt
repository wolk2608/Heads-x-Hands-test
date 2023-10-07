class Monster(
    private val name: String,
    private val attack: Int,
    private val defense: Int,
    private val maxHealth: Int,
    private val minDamage: Int,
    private val maxDamage: Int
): Creature(
    name = name,
    attack = attack,
    defense = defense,
    maxHealth = maxHealth,
    minDamage = minDamage,
    maxDamage = maxDamage
) {

}