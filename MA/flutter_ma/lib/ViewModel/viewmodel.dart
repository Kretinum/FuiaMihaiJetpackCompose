
import 'package:flutter/cupertino.dart';
import 'package:flutter_ma/domain/dish.dart';

class ViewModel with ChangeNotifier{
  List<dish> dishes = <dish>[
    new dish(1, "Goulash", "De toate", "Amesteca Tovarase", result_type.OK, Image.network("https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fgcl.dunster.nl%2Fwp-content%2Fuploads%2F2011%2F11%2FBeef-Goulash-3.jpg&f=1&nofb=1")),
    new dish(2, "Ciorba De burta", "De toate", "Amesteca Tovarase", result_type.OK, Image.network("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.EvxIB-VKCeR_PgU5f8ZJlQHaFE%26pid%3DApi&f=1")),
    new dish(3, "Placinta", "De toate", "Amesteca Tovarase", result_type.OK, Image.network("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.pinimg.com%2Foriginals%2F25%2F00%2F13%2F250013cb42ca5492004abf098bc6b86e.png&f=1&nofb=1"))
  ];

  ViewModel();

  void add(dish X)
  {

    int max = 0;
    for (int i=0;i<dishes.length;i++) {
      if (dishes[i].ID>max) {
        max=dishes[i].ID;
      }
    }
    X.ID= max+1;
    dishes.add(X);
    notifyListeners();

  }

  void remove_id(int ID)
  {
    dishes.removeWhere((D) => D.ID == ID);
    notifyListeners();
  }

  void update_id(int ID,dish X)
  {

    for (int i=0;i<dishes.length;i++) {
      if (dishes[i].ID==ID) {
        dishes[i]=X;
        break;
      }
    }
    notifyListeners();
  }

  List<dish> get_dishes()
  {
    return dishes;

  }

  dish get_one(int ID)
  {
    for (int i=0;i<dishes.length;i++) {
      if (dishes[i].ID==ID) {
        return dishes[i];
      }
    }
    return new dish(0,"","","",result_type.OK,new Image.network(""));
  }
}