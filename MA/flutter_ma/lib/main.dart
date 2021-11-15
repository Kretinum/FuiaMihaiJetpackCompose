

import 'package:flutter/material.dart';
import 'package:flutter_ma/ViewModel/viewmodel.dart';
import 'package:flutter_ma/domain/dish.dart';
import 'package:flutter_ma/routing/route_gen.dart';
import 'package:flutter_ma/routing/routes.dart';
import 'package:provider/provider.dart';

import 'list_window.dart';
/*
void main(){

  dish dish1 = ;
  dish dish2 = ;
  dish dish3 =
  final List<dish> dishes = <dish>[dish1,dish2,dish3];

  ViewModel vm = new ViewModel(dishes);


  runApp(MaterialApp(title: 'FoodList',
      home:ListWindow(vm)));
}
*/


void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (context) => ViewModel())
      ],
      builder: (context, child) {
        return const MaterialApp(
          title: 'Flutter Demo',
          initialRoute: list_view_route,
          onGenerateRoute: generateRoute,
        );
      },
    );
  }
}
