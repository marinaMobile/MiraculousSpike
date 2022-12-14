package com.aqupepgames.projectp.four.repo

import com.aqupepgames.projectp.four.inter.HostInterface

class DevRepo(private val devData: HostInterface) {
    suspend fun getDataDev() = devData.getDataDev()
}