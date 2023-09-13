import bank.ApexBank
import bank.Bank
import bank.CommercialBank
import misc.Reviewer
import misc.ReviewerRole
import wallet.classes.CommerceWallet
import wallet.classes.MerchantWallet
import wallet.interfaces.IWallet

fun main() {
//    kotlinDataTypes()
    workingWithClasses()
//    workingWithDataClasses()

    val commerceWallets = arrayOf(
        CommerceWallet("User1", 10.0),
        CommerceWallet("User2", 100.0),
        CommerceWallet("User3", 40.0))

    findBigBoys(*commerceWallets)

}

fun findBigBoys(vararg wallets : CommerceWallet) {
    val bigBoys = wallets.filter { it.getBalance() >= 100 }

    bigBoys.forEach{
        println("${it.getWalletOwner()} is a bigboy with balance ${it.getBalance()}")
    }
}

fun getLoan(amount: Double) : Double {
    val interestPercent = 10/100

    return interestPercent * amount
}

fun controlFlow() {
    val reviewer = Reviewer("James", ReviewerRole.FINAL)
    when (reviewer.role) {
        ReviewerRole.INTERIM -> println("This is interim approver")
        ReviewerRole.FINAL -> println("This is the Final approver")
        ReviewerRole.INTERMEDIATE -> println("This is the intermediate")
    }
}

fun kotlinDataTypes() {
    val nullableValue: Any? = null
    /** Immutable data is constant and can not be re-assigned **/
    val immutableStringData : String = "Welcome to Kotlin"
    val char : Char = 'D'
    val functional : Boolean = true
    val accountBalance : Long = 10000000000L
    // Gives unexpected result because value is out of range
    val accountBalanceInt : Int = accountBalance.toInt()
    /** Below works because no value has yet been assigned to the variable name **/
//    val defferedVariableInitialization : String
//    defferedVariableInitialization = "James Online!"
//    println(defferedVariableInitialization)

    /** Below throws an error because the name `immutableStringData` is immutable */
//    immutableStringData = "New data"

    /** Creating Mutable variables **/
    var mutableIntData : Int = 4
    mutableIntData = 7
    /** This will not work because we were explicit about Int datattype above */
//    mutableIntData = "Something"

    var mutableAnyData : Any? = 5
    mutableAnyData = "Changed datatype"
    println(mutableAnyData)
}

fun workingWithClasses() {
    printBreak("Commerce Wallet")
    val commerceWallet = CommerceWallet("Ola", 100.0)
    println("Wallet state is ${commerceWallet.getWalletState()}")
    commerceWallet.printUserBalance()

    printBreak("Merchant Wallet")
    val merchantWallet = MerchantWallet("Shoprite", 100000000.0)
    println("Wallet state is ${merchantWallet.getWalletState()}")

    printBreak("Commerce Wallet Via Interface Type")
    val cw : IWallet = CommerceWallet("Olamide", 1000.00)
    /** Next statement will return an error because we specified type as IWallet
     * which is missing the additional function `printUserBalance` */
//    println(cw.printUserBalance())
    println("${cw.ownerName} has a balance of ${cw.getBalance()}")
    println("Wallet state is ${cw.getWalletState()}")
//
    printBreak("Create Apex Bank")
    val ab : Bank = ApexBank()
    println(ab.printName())
    ab.overridableFunction()

    printBreak("Create Commercial Bank")
    val cb : Bank = CommercialBank("Diamond")
    val cbName = cb.printName()
    println(cbName)
    cb.overridableFunction()
    if (cb is ApexBank) {
        println("$cbName is an Apex Bank")
    }

    printBreak("Transfer Funds -> Function not overriden in CommercialBank Class")
    cb.sendFunds(commerceWallet, cw, 30.0)

    printBreak("Transfer Funds with Apex Bank")
    ab.sendFunds(commerceWallet, cw, 30.0)
}

fun workingWithDataClasses() {
    printBreak("Working with DataClasses")
    val firstReviewer = Reviewer("Treasurer")
    println(firstReviewer.name)

    val secondReviewer = Reviewer("Auditor")
    val thirdReviewer = Reviewer("Manager")

    /**
     * Kotlin compiler helps generate needed implementation for deep comparison of data classes
     * This is based on constructor properties that are defined
     * - It also provides a copy function to copy data from one variable to the other
     * */
    val pseudoFirstReviewer = firstReviewer.copy()
    if (pseudoFirstReviewer == firstReviewer) {
        println("This First Guy is the same reviewer")
    } else {
        println("This First Guy is NOT the same reviewer")
    }

    val pseudoSecondReviewer = secondReviewer.copy(role = ReviewerRole.FINAL)
    if (pseudoSecondReviewer == secondReviewer) {
        println("This Second Person is the same reviewer")
    } else {
        println("This Second Guy is NOT the same reviewer")
    }

    printBreak("Destructuring with DataClasses")
    val (name, role) = pseudoSecondReviewer
    println("Pseudo's name is $name")
    println("Pseudo's role is $role")
}
private fun printBreak(title: String = "Section") {
    println("\n****************************** $title *************************************** \n")
}