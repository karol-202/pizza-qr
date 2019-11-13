package pl.grinchscode.pizzaqr.service

interface TokenService
{
	suspend fun isTokenActive(token: String): Boolean?
}
