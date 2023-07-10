def soundsjava(id):
    base = 'public static final SoundEvent {id_capital} = new SoundEvent(new ResourceLocation(Rtgpowergen.MOD_ID ,"{id}")).setRegistryName(Rtgpowergen.MOD_ID, "{id}");'
    with open("../java/com/github/chronoselectronics/rtgpowergen/Utils/Sounds.java") as f:
        before_content = f.read()[:-2]

    with open("../java/com/github/chronoselectronics/rtgpowergen/Utils/Sounds.java", "w") as f:
        f.write(before_content + "\n" + base.replace("{id}", id).replace("{id_capital}", id.upper()) + "\n}")

def itemsjava(id):
    with open("../java/com/github/chronoselectronics/rtgpowergen/items/Items.java") as f:
        before_content = f.read()

    item_instance = 'static public final MusicDisc {id_capital} = new MusicDisc("{id}", Sounds.{id_capital});'\
                        .replace("{id}", id).replace("{id_capital}", id.upper())\
                    + "\n    // LEAVE THAT HERE {AUTOMATION MARK 1}"
    item_register = '{id_capital}.register();'.replace("{id_capital}", id.upper()) + "\n        // LEAVE THAT HERE {AUTOMATION MARK 2}"

    with open("../java/com/github/chronoselectronics/rtgpowergen/items/Items.java", "w") as f:
        f.write(before_content.replace("// LEAVE THAT HERE {AUTOMATION MARK 1}", item_instance).replace("// LEAVE THAT HERE {AUTOMATION MARK 2}", item_register))

def soundsjson(id):
    base = '"{id}": {\n    "category": "record",\n    "sounds": [\n      {\n        "name": "rtgpowergen:{id}",\n        "stream": true\n      }\n    ]\n  }'
    with open("../resources/assets/rtgpowergen/sounds.json") as f:
        before_content = f.read()[:-2]

    with open("../resources/assets/rtgpowergen/sounds.json", "w") as f:
        f.write(before_content + "," + base.replace("{id}", id) + "\n}")

def itemmodel(id, texture_path):
    contents = '{\n  "parent": "item/generated",\n  "textures": {\n    "layer0": "rtgpowergen:items/discs/{texture_path}"\n  }\n}\n'.replace("{texture_path}", texture_path+"/"+id)
    with open(f"../resources/assets/rtgpowergen/models/item/record_{id}.json", "w") as f:
        f.write(contents)

def translation_key(id, translation):
    with open("../resources/assets/rtgpowergen/lang/en_US.lang", "a") as f:
        f.write("\n" + f"item.record.{id}.desc=" + translation)



def main():
    id = input("id?:" )
    texture = input("special texture path?: ")
    translation = input("song artist / name?: ")
    soundsjson(id)
    soundsjava(id)
    itemsjava(id)
    itemmodel(id, texture)
    translation_key(id, translation)

if __name__ == "__main__":
    main()