package chain.rule

import chain.SellValueCalculationRule
import model.Brand
import model.Type
import model.Vehicle

/**
 * Classe de regra para o cálculo do preço de venda para veículos CHEVROLET do tipo PICKUP
 */
class ChevroletPickupSellValueCalculationRule : SellValueCalculationRule() {

    override fun shouldCalculate(
        vehicle: Vehicle,
    ) = vehicle.type == Type.PICKUP && vehicle.brand == Brand.CHEVROLET

    override fun doCalculation(vehicle: Vehicle): Double {
        return vehicle.value +
                ((vehicle.value * CHEVROLET_PICKUP_INTEREST_PERCENTAGE_VALUE) / 100) -
                CHEVROLET_PICKUP_DISCOUNT_MONETARY_VALUE
    }

    companion object {
        private const val CHEVROLET_PICKUP_INTEREST_PERCENTAGE_VALUE = 0.49
        private const val CHEVROLET_PICKUP_DISCOUNT_MONETARY_VALUE = 1500.00
    }
}