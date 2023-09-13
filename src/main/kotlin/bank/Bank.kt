package bank

import bank.interfaces.IBank
import wallet.interfaces.IWallet

/**
 * Classes are closed for extension by default, to extend a class specify 'open' modifier
 */
open class Bank(name: String) : IBank {
    private var bankName = name
    init {
        check(!name.isNullOrEmpty()) {
            "A Bank name can not be empty"
        }
    }

    fun printName() : String {
        return bankName
    }

    override fun sendFunds(source: IWallet, destination: IWallet, amount: Double) {
        if (amount > source.getBalance()) {
            throw IllegalArgumentException("The amount can not be greater than the balance")
        }
    }

    open fun overridableFunction() {
        println("Not Overriden")
    }
}