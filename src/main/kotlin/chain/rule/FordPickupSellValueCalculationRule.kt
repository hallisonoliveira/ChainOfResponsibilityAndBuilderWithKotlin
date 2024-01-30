package chain.rule

import chain.SellValueCalculationRule
import model.Brand
import model.Type
import model.Vehicle

/**
 * Classe de regra para o cálculo do preço de venda para veículos FORD do tipo PICKUP
 */
class FordPickupSellValueCalculationRule : SellValueCalculationRule() {

    override fun shouldCalculate(
        vehicle: Vehicle,
    ) = vehicle.type == Type.PICKUP && vehicle.brand == Brand.FORD

    override fun doCalculation(
        vehicle: Vehicle
    ) = vehicle.value +
            ((vehicle.value * FORD_PICKUP_INTEREST_PERCENTAGE_VALUE) / 100) -
            FORD_PICKUP_DISCOUNT_MONETARY_VALUE

    companion object {
        private const val FORD_PICKUP_INTEREST_PERCENTAGE_VALUE = 0.69
        private const val FORD_PICKUP_DISCOUNT_MONETARY_VALUE = 2000.00
    }
}