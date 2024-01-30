package chain.rule

import chain.SellValueCalculationRule
import model.Vehicle

/**
 * Classe de regra para o cálculo do preço de venda padrão para qualquer veículo
 */
class DefaultDiscountCalculationRule : SellValueCalculationRule() {

    override fun shouldCalculate(
        vehicle: Vehicle,
    ) = true

    override fun doCalculation(
        vehicle: Vehicle
    ) = vehicle.value - ((vehicle.value * GENERAL_DISCOUNT_PERCENTAGE_VALUE) / 100)

    companion object {
        private const val GENERAL_DISCOUNT_PERCENTAGE_VALUE = 0.1
    }
}