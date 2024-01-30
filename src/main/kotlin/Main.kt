import chain.*
import chain.rule.*
import model.Brand
import model.Type
import model.Vehicle

fun main() {
    println("Sistema de cálculo de preço de venda")

    /** Criação dos veículos para serem utilizados nos cálculos **/
    val chevroletCamaro = Vehicle(
        type = Type.CAR,
        brand = Brand.CHEVROLET,
        value = 150000.00
    )

    val chevroletSilverado = Vehicle(
        type = Type.PICKUP,
        brand = Brand.CHEVROLET,
        value = 190000.00
    )

    val fordMaverick = Vehicle(
        type = Type.CAR,
        brand = Brand.FORD,
        value = 155000.00
    )

    val fordRanger = Vehicle(
        type = Type.PICKUP,
        brand = Brand.FORD,
        value = 185000.00
    )

    val fordBus = Vehicle(
        type = Type.BUS,
        brand = Brand.FORD,
        value = 200000.00
    )

    /** Criação da cadeia de regras de cálculos **/
    val sellCalculationChain = SellValueCalculationChain.Builder
        .add(ChevroletCarSellValueCalculationRule())
        .add(ChevroletPickupSellValueCalculationRule())
        .add(FordCarSellValueCalculationRule())
        .add(FordPickupSellValueCalculationRule())
        .setDefault(DefaultDiscountCalculationRule())
        .build()

    /** Calculo de venda do Chevrolet Camaro **/
    val chevroletCamaroSellValue = sellCalculationChain.run(chevroletCamaro)
    println("Chevrolet Camaro\n\t- Preço de tabela: ${chevroletCamaro.value}\n\t- Preço de venda: ${chevroletCamaroSellValue}\n")
    /**
     * Chevrolet Camaro
     * 	- Preço de tabela: 150000.0
     * 	- Preço de venda: 151485.0
     */

    /** Calculo de venda do Chevrolet Silverado **/
    val chevroletSilveradoSellValue = sellCalculationChain.run(chevroletSilverado)
    println("Chevrolet Silverado\n\t- Preço de tabela: ${chevroletSilverado.value}\n\t- Preço de venda: ${chevroletSilveradoSellValue}\n")
    /**
     * Chevrolet Silverado
     * 	- Preço de tabela: 190000.0
     * 	- Preço de venda: 189431.0
     */

    /** Calculo de venda do Ford Maverick **/
    val fordMaverickSellValue = sellCalculationChain.run(fordMaverick)
    println("Ford Maverick\n\t- Preço de tabela: ${fordMaverick.value}\n\t- Preço de venda: ${fordMaverickSellValue}\n")
    /**
     * Ford Maverick
     * 	- Preço de tabela: 155000.0
     * 	- Preço de venda: 155759.5
     */

    /** Calculo de venda do Ford Ranger **/
    val fordRangerSellValue = sellCalculationChain.run(fordRanger)
    println("Ford Ranger\n\t- Preço de tabela: ${fordRanger.value}\n\t- Preço de venda: ${fordRangerSellValue}\n")
    /**
     * Ford Ranger
     * 	- Preço de tabela: 185000.0
     * 	- Preço de venda: 184276.5
     */

    /** Calculo de venda do onibus Ford **/
    val fordBusSellValue = sellCalculationChain.run(fordBus)
    println("Onibus Ford\n\t- Preço de tabela: ${fordBus.value}\n\t- Preço de venda: ${fordBusSellValue}\n")
    /**
     * Onibus Ford
     * 	- Preço de tabela: 200000.0
     * 	- Preço de venda: 199800.0
     */
}