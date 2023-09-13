package misc

/** A data class must have at least one constructor parameter*/
enum class ReviewerRole {
    FINAL, INTERIM, INTERMEDIATE
}
data class Reviewer(val name: String, val role: ReviewerRole = ReviewerRole.INTERIM)
