import 'package:flutter/material.dart';
import 'package:flutter_ma/ViewModel/viewmodel.dart';
import 'package:flutter_ma/create_window.dart';
import 'package:flutter_ma/domain/dish.dart';
import 'package:flutter_ma/edit_window.dart';
import 'package:flutter_ma/routing/routes.dart';
import 'package:flutter_ma/widgets/food_item.dart';
import 'package:provider/src/provider.dart';

class ListWindow extends StatefulWidget{
  ListWindow();
  _ListWindow createState()=>_ListWindow();

}


class _ListWindow extends State<ListWindow>{

  _ListWindow();
  //ListWindow(this.VM);

  @override
  Widget build(BuildContext context){
    List<dish> dishes = Provider.of<ViewModel>(context).get_dishes();
    print("cacat");
        return Scaffold(
            appBar: AppBar(title: Text('Foodlist'),),
            body:

            Column( children: <Widget>[


            Expanded(child: ListView.builder(
                itemCount: dishes.length,
                itemBuilder:(BuildContext context,int index){
                  return FoodItem(dishes[index].ID);
                }
            )),
            Align(alignment:Alignment.bottomCenter,child:SizedBox(height:40,width: double.infinity,child:ElevatedButton(onPressed: () {

              Navigator.of(context).pushNamed(add_view_route);

            }, child:  Text('+',style: TextStyle(color: Colors.black)),style: ElevatedButton.styleFrom(primary: Colors.red,padding: EdgeInsets.all(5.0)))))
            ],





        )
    );
}
}