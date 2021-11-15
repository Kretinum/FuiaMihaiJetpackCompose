import 'package:flutter/material.dart';
import 'package:flutter_ma/ViewModel/viewmodel.dart';
import 'package:provider/provider.dart';

import 'domain/dish.dart';




class CreateWindow extends StatefulWidget{
  CreateWindow();
  _CreateWindow createState()=>_CreateWindow();
}

class _CreateWindow extends State<CreateWindow>{
  String val_name="";
  String val_ingr="";
  String val_recipe="";
  result_type selectedValue=result_type.OK;
  bool up = false;

  _CreateWindow();







  @override
  Widget build(BuildContext context) {

    return  Scaffold(
        appBar: AppBar(title: Text('Add Food Item'),),
        body: Column(
          children: <Widget>[
            Row(
              children: <Widget>[
                Expanded(child: TextField(decoration: InputDecoration(hintText: "Name"),onChanged: (text){val_name=text;},))
              ],
            ),
            Expanded(child: TextField(decoration: InputDecoration(hintText: "Ingredients"),maxLines: 20,onChanged: (text){val_ingr=text;},)),
            Expanded(child: TextField(decoration: InputDecoration(hintText: "Recipe"),maxLines: 20,onChanged: (text){val_recipe=text;},)),

            DropdownButton(value: selectedValue, items: const [
              DropdownMenuItem(child: Text("CATASTROPHE"),value: result_type.CATASTROPHE,),
              DropdownMenuItem(child: Text("FAILURE"),value: result_type.FAILURE,),
              DropdownMenuItem(child: Text("OK"),value: result_type.OK,),
              DropdownMenuItem(child: Text("SUCCESS"),value: result_type.SUCCESS,),
              DropdownMenuItem(child: Text("MAGNUM_OPUS"),value: result_type.MAGNUM_OPUS,),
            ],
              onChanged: (value){
                setState(() {
                  selectedValue = value as result_type;
                }
                );
              },
            ),

            //MyDropDown(sel: selectedValue),
            Expanded(child: Align(alignment:Alignment.bottomCenter,child:SizedBox(height:40,width: double.infinity,child:ElevatedButton(onPressed: () {
              if (val_recipe=="" || val_name=="" || val_ingr=="")
                {
                  showDialog(context: context, builder: (ctx) => AlertDialog(
                    title: Text("Invalid!"),
                    content: Text("Please fill all the boxes!"),
                    actions: <Widget>[
                      TextButton(onPressed: ()
                      {
                        Navigator.of(ctx).pop();
                      }, child: Text("Aight"))
                    ],
                  ));
                }
              else {
                Provider.of<ViewModel>(context, listen: false).add(dish(
                    -1, val_name, val_ingr, val_recipe, selectedValue,
                    Image.network(
                        "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.MahPMiwMvSwjKTegXpkfMAHaFk%26pid%3DApi&f=1")));
                Navigator.pop(context);
              }

            }, child:  Text('Add',style: TextStyle(color: Colors.black)),style: ElevatedButton.styleFrom(primary: Colors.red,padding: EdgeInsets.all(5.0))))))
          ],
        )
    );


  }

}