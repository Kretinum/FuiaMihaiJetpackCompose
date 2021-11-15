

import 'package:flutter/cupertino.dart';

enum  result_type{
CATASTROPHE,FAILURE,OK,SUCCESS,MAGNUM_OPUS
}

class dish{
  int _ID;

  int get ID => _ID;

  set ID(int ID) {
    _ID = ID;
  }
  String _Name;

  String get Name => _Name;

  set Name(String Name) {
    _Name = Name;
  }
  String _Ingredients;

  String get Ingredients => _Ingredients;

  set Ingredients(String Ingredients) {
    _Ingredients = Ingredients;
  }
  String _Recipe;

  String get Recipe => _Recipe;

  set Recipe(String Recipe) {
    _Recipe = Recipe;
  }
  result_type _Results;

  result_type get Results => _Results;

  set Results(result_type Results) {
    _Results = Results;
  }
  Image _Img;

  Image get Img => _Img;

  set Img(Image Img) {
    _Img = Img;
  }

  dish(this._ID, this._Name, this._Ingredients, this._Recipe, this._Results,
      this._Img);

}