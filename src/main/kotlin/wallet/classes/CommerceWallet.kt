package wallet.classes

import wallet.interfaces.IWallet

/**
 * Defining class properties owner and balance without explicit getters and setters
 * properties are public by default unless we specify 'private' visibility modifier
 */
class CommerceWallet(private val owner: String, private var balance: Double) : IWallet {
    private val limit = 1000000
    override val ownerName: String
        get() = owner
    init {
        check(balance < limit) {
            "Commerce Wallet can not have a balance greater $limit"
        }
    }

    override fun getWalletOwner() : String {
        return owner
    }

    fun printUserBalance() {
        println("$owner has a balance of $balance")
    }

    override fun receiveFund(source: IWallet, amount: Double): Double {
        println("Receiving $amount from ${source.ownerName}")
        balance += amount
        return balance
    }

    override fun sendFund(destination: IWallet, amount: Double): Double {
        println("Sending $amount to ${destination.ownerName}")
        balance -= amount
        return balance
    }

    override fun getBalance(): Double {
        return balance
    }

    override fun getLimit(): Int {
        return limit;
    }
}