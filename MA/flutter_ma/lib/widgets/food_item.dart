import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_ma/ViewModel/viewmodel.dart';
import 'package:flutter_ma/domain/dish.dart';
import 'package:flutter_ma/routing/routes.dart';
import 'package:provider/provider.dart';

import '../edit_window.dart';



class FoodItem extends StatefulWidget{
  int ID;
  FoodItem(this.ID);
  _FoodItem createState()=>_FoodItem(ID);
}

class _FoodItem extends State<FoodItem>{

  int ID;

  _FoodItem(this.ID);

  @override
  Widget build(BuildContext context) {
    dish Dish = Provider.of<ViewModel>(context).get_one(ID);
    print(Dish.Name);
    return Container(
        height:90,
        padding:EdgeInsets.all(15.0),
        child: ElevatedButton(onPressed: () {

          Navigator.of(context).pushNamed(edit_view_route,arguments: ID);
          },
          child: Row(
            children: <Widget>[
              Expanded(child: Image(image:  Dish.Img.image,)),
              Expanded(child: Text(Dish.Name),),
              Expanded(child: ElevatedButton(onPressed: () {

                showDialog(context: context, builder: (ctx) => AlertDialog(
                  title: Text("Delete?"),
                  content: Text("Are you sure you want to delete?"),
                  actions: <Widget>[
                    TextButton(onPressed: ()
                    {
                        Provider.of<ViewModel>(context,listen: false).remove_id(ID);
                        Navigator.of(ctx).pop();
                    }, child: Text("Yes")),
                    TextButton(onPressed: ()
                    {
                      Navigator.of(ctx).pop();
                    }, child: Text("No"))
                  ],
                ));



              }

              , child:  Text('X',style: TextStyle(color: Colors.black)),style: ElevatedButton.styleFrom(primary: Colors.red),
              )),
            ],
          ),

        ));
  }

}

