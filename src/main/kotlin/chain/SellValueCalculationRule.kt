package chain

import model.Vehicle

/**
 * Classe que define o contrato a ser seguido pelas classe de regras - elos da cadeia
 */
abstract class SellValueCalculationRule {

    protected abstract fun shouldCalculate(
        vehicle: Vehicle,
    ): Boolean

    protected abstract fun doCalculation(
        vehicle: Vehicle,
    ): Double

    fun run(
        vehicle: Vehicle,
    ) = if (shouldCalculate(vehicle)) {
        doCalculation(vehicle)
    } else {
        null
    }
}