package chain.rule

import chain.SellValueCalculationRule
import model.Brand
import model.Type
import model.Vehicle

/**
 * Classe de regra para o cálculo do preço de venda para veículos FORD do tipo CAR
 */
class FordCarSellValueCalculationRule : SellValueCalculationRule() {

    override fun shouldCalculate(
        vehicle: Vehicle,
    ) = vehicle.type == Type.CAR && vehicle.brand == Brand.FORD

    override fun doCalculation(
        vehicle: Vehicle,
    ) = vehicle.value + ((vehicle.value * CHEVROLET_CAR_INTEREST_VALUE) / 100)

    companion object {
        private const val CHEVROLET_CAR_INTEREST_VALUE = 0.49
    }
}