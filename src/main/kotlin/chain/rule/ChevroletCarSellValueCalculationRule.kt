package chain.rule

import chain.SellValueCalculationRule
import model.Brand
import model.Type
import model.Vehicle

/**
 * Classe de regra para o cálculo do preço de venda para veículos CHEVROLET do tipo CAR
 */
 class ChevroletCarSellValueCalculationRule : SellValueCalculationRule() {

    override fun shouldCalculate(
        vehicle: Vehicle,
    ) = vehicle.type == Type.CAR && vehicle.brand == Brand.CHEVROLET

    override fun doCalculation(vehicle: Vehicle): Double {
        return vehicle.value + ((vehicle.value * CHEVROLET_CAR_INTEREST_VALUE) / 100)
    }

    companion object {
        private const val CHEVROLET_CAR_INTEREST_VALUE = 0.99
    }
}