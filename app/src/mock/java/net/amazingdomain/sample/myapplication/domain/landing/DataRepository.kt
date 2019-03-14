package net.amazingdomain.sample.myapplication.domain.landing

class DataRepository : IDataRepository {

    private var size = 5

    override fun fetchData(): List<String> {


        val list = mutableListOf<String>()

        for (i in 0..(size - 1)) {
            list += "Kitty # $i"
        }

        size++
        return list
    }

}