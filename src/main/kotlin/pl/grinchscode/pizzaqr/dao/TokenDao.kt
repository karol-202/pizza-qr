package pl.grinchscode.pizzaqr.dao

import pl.grinchscode.pizzaqr.model.Token

interface TokenDao
{
	suspend fun findToken(token: String): Token?
}
