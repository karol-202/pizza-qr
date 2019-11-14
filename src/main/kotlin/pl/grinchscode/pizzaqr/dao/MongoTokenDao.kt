package pl.grinchscode.pizzaqr.dao

import pl.grinchscode.pizzaqr.model.Token

class MongoTokenDao(database: MongoDatabase) : TokenDao
{
	private val collection = database.getCollection<Token>()

	override suspend fun findToken(token: String) = collection.findOneById(token)

	override suspend fun insertToken(token: Token) =
		if(collection.findOneById(token._id) == null) collection.insertOne(token).let { true } else false
}
