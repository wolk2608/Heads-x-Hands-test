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

    fun getCreatureName(): String { return name }
    fun getCreatureAttack(): Int { return attack }
    fun getCreatureDefense(): Int { return defense }
    fun getCreatureMaxHealth(): Int { return maxHealth }
    fun getCreatureMinDamage(): Int { return minDamage }
    fun getCreatureMaxDamage(): Int { return maxDamage }
    fun getCreatureCurrentHealth(): Int { return currentHealth }
    fun getCreatureIsAliveState(): Boolean { return isAlive }

    fun dealDamage(enemyDefence: Int): Int {
        if (isAlive) {
            val attackModifier = attack - enemyDefence + 1
            for (roll in 1..attackModifier) {
                val dice = (1..6).random()
                if (dice >= 5) {
                    val damage = (minDamage..maxDamage).random()
                    println("The attack from ${name} dealt ${damage} damage.")
                    return damage
                }
            }
            println("The attack from ${name} missed.")
        } else {
            println("Attack is not available. Creature ${name} is dead.")
        }
        return 0
    }

    fun takeDamage(damage: Int) {
        if (damage > 0) {
            if (isAlive) {
                if (currentHealth - damage <= 0) {
                    currentHealth = 0
                    isAlive = false
                    println("The attack to creature ${name} deals ${damage} damage.\nCreature ${name} died.")
                } else {
                    currentHealth -= damage
                    println("The attack to creature ${name} deals ${damage} damage.\nCreature ${name} is still alive.\nHis current hp = ${currentHealth}.")
                }
            } else {
                println("The attack to creature ${name} has no effect. Creature ${name} is already dead.")
            }
        }
    }
}

// Все сущности должны быть написаны и спроектированы в ООП стиле. Объекты обязательно должны реагировать на некорректные аргументы методов.
// В вашей программе обязательно должны получиться классы сущностей Игрок и Монстр. Наличие дополнительных классов по вашему желанию.
//
// Результатом должно стать приложение с реализацией классов и примером их использования.