package wallet.interfaces

import wallet.enums.WalletState

/**
 * Defining reusable contracts
 * which can be used by interfaces, classes and objects
 */
interface IWallet {
    val ownerName: String
    fun receiveFund(source : IWallet, amount: Double): Double

    fun sendFund(destination : IWallet, amount: Double): Double

    fun getBalance(): Double

    fun getLimit(): Int
    /** It is also possible to define default implementation for an interface*/
    fun getWalletState(): WalletState = WalletState.ACTIVE
}