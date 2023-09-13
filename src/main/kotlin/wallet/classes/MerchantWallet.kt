package wallet.classes

import wallet.interfaces.IWallet

class MerchantWallet(private val owner: String, balance: Double) : IWallet {
    private val limit = 100000000
    init {
        check(balance >= limit) {
            "Merchant can not have an amount less than $limit"
        }
    }

    override val ownerName: String
        get() = owner

    override fun getWalletOwner() : String {
        return owner
    }

    override fun receiveFund(source: IWallet, amount: Double): Double {
        TODO("Not yet implemented")
    }

    override fun sendFund(destination: IWallet, amount: Double): Double {
        TODO("Not yet implemented")
    }

    override fun getBalance(): Double {
        TODO("Not yet implemented")
    }

    override fun getLimit(): Int {
        TODO("Not yet implemented")
    }
}