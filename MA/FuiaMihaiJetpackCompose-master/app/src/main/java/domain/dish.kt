package domain

import android.media.Image

enum class result_type{
    CATASTRPHE,FAILURE,OK,SUCCESS,MAGNUM_OPUS
}
class dish {
    var ID: Long? = 0
        get() = field
        set(value){
            field=value
        }
    var Name: String = ""
        get() = field
        set(value){
            field=value
        }
    var Ingredients: String = ""
        get() = field
        set(value){
            field=value
        }
    var Recipe: String = ""
        get() = field
        set(value){
            field=value
        }
    var Results: result_type = result_type.OK
        get() = field
        set(value){
            field=value
        }
    var Image: Int = 0
        get() = field
        set(value){
            field=value
        }

    constructor(
        ID: Long?,
        Name: String,
        Ingredients: String,
        Recipe: String,
        Results: result_type,
        Image: Int
    ) {
        this.ID = ID
        this.Name = Name
        this.Ingredients = Ingredients
        this.Recipe = Recipe
        this.Results = Results
        this.Image = Image
    }

    constructor(
    ) {
        this.ID = -1
    }


}