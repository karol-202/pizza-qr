package pl.grinchscode.pizzaqr.service

import pl.grinchscode.pizzaqr.dao.TokenDao

class TokenServiceImpl(private val tokenDao: TokenDao) : TokenService
{
	override suspend fun isTokenActive(token: String) = tokenDao.findToken(token)?.active
}
