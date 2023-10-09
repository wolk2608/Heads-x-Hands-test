open class Creature(
    private val name: String,
    private val attack: Int,
    private val defense: Int,
    private val maxHealth: Int,
    private val minDamage: Int,
    private val maxDamage: Int
) {
    protected var currentHealth: Int = maxHealth
    protected var isAlive: Boolean = true

    init {
        require(attack in 0..30)
        require(defense in 0..30)
        require(maxHealth > 0)
        require(minDamage > 0)
        require(minDamage <= maxDamage)
    }

    val creatureName get() = name
    val creatureAttack get() = attack
    val creatureDefense get() = defense
    val creatureMaxHealth get() = maxHealth
    val creatureMinDamage get() = minDamage
    val creatureMaxDamage get() = maxDamage
    val creatureCurrentHealth get() = currentHealth
    val creatureIsAliveState get() = isAlive

    fun dealDamage(enemyDefence: Int): Int {
        if (!isAlive) {
            println("Attack is not available. Creature $name is dead.")
            return 0
        }

        val attackModifier = attack - enemyDefence + 1
        for (roll in 1..attackModifier) {
            val dice = (1..6).random()
            if (dice >= 5) {
                val damage = (minDamage..maxDamage).random()
                println("The attack from $name dealt $damage damage.")
                return damage
            }
        }

        println("The attack from $name missed.")
        return 0
    }

    fun takeDamage(damage: Int) {
        if (damage <= 0) {
            return
        }
        if (!isAlive) {
            println("The attack to creature $name has no effect. Creature $name is already dead.")
            return
        }

        if (currentHealth - damage <= 0) {
            currentHealth = 0
            isAlive = false
            println("The attack to creature $name deals $damage damage.\nCreature $name died.")
        } else {
            currentHealth -= damage
            println("The attack to creature $name deals $damage damage.\nCreature $name is still alive.\nHis current hp = $currentHealth.")
        }
    }
}