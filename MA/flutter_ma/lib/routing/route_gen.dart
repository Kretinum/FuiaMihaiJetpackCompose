import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_ma/create_window.dart';
import 'package:flutter_ma/edit_window.dart';
import 'package:flutter_ma/list_window.dart';
import 'package:flutter_ma/routing/routes.dart';

Route<dynamic> generateRoute(RouteSettings settings)
{
  if (settings.name !=null)
    {
      switch (settings.name)
      {
        case list_view_route:
          return MaterialPageRoute(builder: (_) => ListWindow());
        case edit_view_route:
          final args = settings.arguments as int;
          return MaterialPageRoute(builder: (_) => EditWindow(args));
        case add_view_route:
          return MaterialPageRoute(builder: (_) => CreateWindow());
      }
    }
  return _errorRoute();

}
Route<dynamic> _errorRoute() {
  return MaterialPageRoute(builder: (_) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Error'),
      ),
      body: const Center(
        child: Text('ERROR'),
      ),
    );
  });
}