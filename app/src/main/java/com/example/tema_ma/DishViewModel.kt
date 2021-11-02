package com.example.tema_ma

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.util.function.Predicate
import androidx.lifecycle.ViewModel
import domain.dish

class DishViewModel : ViewModel(){
    private var _DishList: SnapshotStateList<dish> = SnapshotStateList<dish>()

    public fun set_list(X: SnapshotStateList<dish>)
    {
        _DishList = X
    }
    @RequiresApi(Build.VERSION_CODES.N)
    public fun remove_id(aux: Long)
    {
        //_DishList.removeIf(Predicate { x->x.ID.toInt() == aux })
        _DishList.removeIf(Predicate { x->x.ID == aux })
    }
    public fun get_list(): SnapshotStateList<dish> {
        return _DishList
    }

    public fun add(x: dish)
    {
        _DishList.add(x)
    }

    public fun get(ID: Long?): dish {
        _DishList.forEach()
        {
            if (it.ID == ID)
                return it
        }
        return dish()
    }
    public fun update(ID: Long?,X: dish)
    {
        for (i in 0.._DishList.size-1)
        {
            if (_DishList[i].ID==ID)
                _DishList[i] = X
        }
    }
    public fun get_unsused_id() : Long
    {
        var max:Long = 0
        for (i in 0.._DishList.size-1)
        {
            if (_DishList[i].ID!! > max)
                max = _DishList[i].ID!!
        }
        return max+1
    }
}