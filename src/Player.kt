class Player(
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
    private var healCounter = 4
    val playerHealCounter get() = healCounter

    fun heal () {
        if (!isAlive) {
            println("Heal is not available. Player $name is dead.")
            return
        }
        if (healCounter <= 0) {
            println("Heal is not available. Player $name can no longer use the heal.")
            return
        }
        if (currentHealth >= maxHealth) {
            println("Heal was not used. Player $name has full hp.")
            return
        }

        healCounter--
        val healValue =
            if (currentHealth + (0.3 * maxHealth).toInt() > maxHealth) {
                maxHealth - currentHealth
            } else {
                (0.3 * maxHealth).toInt()
            }
        currentHealth += healValue
        println("Player $name was healed by $healValue hp.")
        println("His current hp = $currentHealth.")
        println("Player $name can use the heal another $healCounter times.")
    }
}