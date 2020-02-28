create table nota(
      id_nota BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
      nota_primeiro DECIMAL(5,2),
      nota_segundo DECIMAL(5,2),
      nota_terceiro DECIMAL(5,2),
      media_final DECIMAL(5,2)
);