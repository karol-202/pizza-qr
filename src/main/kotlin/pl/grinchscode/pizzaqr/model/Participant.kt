package pl.grinchscode.pizzaqr.model

data class Participant(val _id: String,
                       val firstName: String,
                       val surname: String,
                       val tokens: List<String>)
