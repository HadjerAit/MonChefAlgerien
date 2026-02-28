package com.example.monchefalgerien.data

import com.example.monchefalgerien.R



/* ------------------------------
   RECETTES SALÉES
--------------------------------*/

val saltyRecipes = listOf(
    Item(
        id = 1,
        title = "Couscous",
        imageRes = R.drawable.couscous,
        ingredients = listOf(
            "500g de semoule",
            "2 carottes",
            "2 courgettes",
            "1 oignon",
            "Pois chiches",
            "Viande (agneau ou poulet)",
            "Épices : ras el hanout, sel, poivre"
        ),
        description = "Le couscous est un plat emblématique de la cuisine algérienne. Il se compose d’une semoule légère accompagnée de légumes mijotés et d’une viande tendre."
    ),

    Item(
        id = 2,
        title = "Chakhchoukha",
        imageRes = R.drawable.chakhchoukha,
        ingredients = listOf(
            "Pâte traditionnelle (trida ou rechta)",
            "2 tomates",
            "1 oignon",
            "Ail",
            "Pois chiches",
            "Épices : paprika, carvi, sel, poivre"
        ),
        description = "La chakhchoukha est un plat généreux composé de pâtes traditionnelles mélangées à une sauce parfumée aux tomates et aux épices."
    ),

    Item(
        id = 3,
        title = "Rechta",
        imageRes = R.drawable.rechta,
        ingredients = listOf(
            "Pâtes fines maison",
            "Poulet",
            "Pois chiches",
            "Oignon",
            "Cannelle",
            "Beurre",
            "Bouillon"
        ),
        description = "La rechta est un plat traditionnel algérois composé de pâtes fines faites maison servies avec un bouillon parfumé."
    ),

    Item(
        id = 4,
        title = "Mhadjeb",
        imageRes = R.drawable.mhadjeb,
        ingredients = listOf(
            "Semoule fine",
            "Farine",
            "Eau",
            "Sel",
            "Tomates",
            "Oignons",
            "Piments"
        ),
        description = "Les mhadjeb sont des crêpes feuilletées farcies d’une chakchouka aux oignons et tomates, croustillantes et savoureuses."
    ),

    Item(
        id = 5,
        title = "Chorba Frik",
        imageRes = R.drawable.chorba_frik,
        ingredients = listOf(
            "Viande (agneau ou poulet)",
            "Frik (blé vert concassé)",
            "Tomates",
            "Oignon",
            "Pois chiches",
            "Coriandre",
            "Épices : coriandre, sel, poivre, paprika"
        ),
        description = "La chorba frik est une soupe traditionnelle algérienne préparée avec du blé vert concassé, idéale pendant le Ramadan."
    ),

    Item(
        id = 6,
        title = "Tajine Zitoun",
        imageRes = R.drawable.tajine_zitoun,
        ingredients = listOf(
            "Poulet",
            "Olives vertes",
            "Carottes",
            "Citron",
            "Ail",
            "Épices : poivre, curcuma, ras el hanout"
        ),
        description = "Le tajine zitoun est un plat mijoté aux olives vertes et au poulet, parfumé et très apprécié en Algérie."
    )
)

/* ------------------------------
   RECETTES SUCRÉES
--------------------------------*/

val sweetRecipes = listOf(
    Item(
        id = 7,
        title = "Kalb el Louz",
        imageRes = R.drawable.kalb_el_louz,
        ingredients = listOf(
            "Semoule",
            "Sucre",
            "Beurre",
            "Eau de fleur d’oranger",
            "Miel"
        ),
        description = "Kalb el louz est un gâteau moelleux imbibé de miel, très populaire pendant le Ramadan."
    ),

    Item(
        id = 8,
        title = "Makrout",
        imageRes = R.drawable.makrout,
        ingredients = listOf(
            "Semoule moyenne",
            "Pâte de dattes",
            "Beurre fondu",
            "Huile",
            "Miel"
        ),
        description = "Le makrout est un classique de la pâtisserie algérienne, croustillant à l’extérieur et fondant à l’intérieur."
    ),

    Item(
        id = 9,
        title = "Zlabia",
        imageRes = R.drawable.zlabia,
        ingredients = listOf(
            "Farine",
            "Maïzena",
            "Eau",
            "Levure",
            "Miel"
        ),
        description = "La zlabia est une pâtisserie frite en forme de spirale, trempée dans un miel parfumé."
    ),

    Item(
        id = 10,
        title = "Tamina",
        imageRes = R.drawable.tamina,
        ingredients = listOf(
            "Semoule grillée",
            "Beurre",
            "Miel"
        ),
        description = "La tamina est un dessert simple et réconfortant à base de semoule grillée, beurre et miel."
    ),

    Item(
        id = 11,
        title = "Baklawa",
        imageRes = R.drawable.baklawa,
        ingredients = listOf(
            "Feuilles de pâte",
            "Amandes",
            "Beurre",
            "Miel"
        ),
        description = "La baklawa est une pâtisserie feuilletée garnie d’amandes et arrosée de miel."
    ),

    Item(
        id = 12,
        title = "Griwech",
        imageRes = R.drawable.griwach,
        ingredients = listOf(
            "Farine",
            "Beurre",
            "Œufs",
            "Sésame",
            "Miel"
        ),
        description = "Le griwech est une torsade croustillante enrobée de miel et décorée de graines de sésame."
    )
)
