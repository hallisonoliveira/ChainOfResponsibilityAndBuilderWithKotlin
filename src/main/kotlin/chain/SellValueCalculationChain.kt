package chain

import model.Vehicle

/**
 * Classe responsável por armazenar todas as regras da cadeia, chama-las e retornar o resultado quando alguma regra for executada
 */
 class SellValueCalculationChain private constructor() {

    private val calculationRules: MutableList<SellValueCalculationRule> = mutableListOf()
    private var defaultCalculationRule: SellValueCalculationRule? = null

    fun addRule(rule: SellValueCalculationRule) {
        calculationRules.add(rule)
    }

    fun setDefaultRule(rule: SellValueCalculationRule) {
        defaultCalculationRule = rule
    }

    fun run(vehicle: Vehicle): Double {

        calculationRules.forEach { calculationRule ->
            val calculationResult = calculationRule.run(vehicle)
            calculationResult?.run { return this }
        }

        defaultCalculationRule?.run {
            val defaultCalculationResult = run(vehicle)
            defaultCalculationResult?.run { return this }
        }

        return vehicle.value
    }

    object Builder {

        private val rules: MutableList<SellValueCalculationRule> = mutableListOf()
        private var defaultRule: SellValueCalculationRule? = null

        fun add(rule: SellValueCalculationRule) = apply {
            rules.add(rule)
        }

        fun setDefault(rule: SellValueCalculationRule) = apply {
            defaultRule = rule
        }

        fun build(): SellValueCalculationChain {
            val chain = SellValueCalculationChain()
            rules.forEach(chain::addRule)
            defaultRule?.run(chain::setDefaultRule)
            return chain
        }
    }
}

