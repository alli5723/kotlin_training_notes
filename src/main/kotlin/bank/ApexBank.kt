package bank

import wallet.interfaces.IWallet

class ApexBank() : Bank("Central Bank") {
    override fun overridableFunction() {
//        super.overridableFunction()
        println("Function is Overriden in our CenBank class")
    }

    override fun sendFunds(source: IWallet, destination: IWallet, amount: Double) {
        super.sendFunds(source, destination, amount)

        val sourceBalance = source.sendFund(destination, amount)
        val destinationBalance = destination.receiveFund(source, amount)

        println("The Accounts have new balances as follows")
        println("Source $sourceBalance")
        println("Destination $destinationBalance")
    }
}