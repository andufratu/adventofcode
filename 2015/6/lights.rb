class Lights
  @@pattern = Regexp.new(/(turn on|turn off|toggle) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)/)

  def initialize(instructions)
    @lights = Array.new(1000) { Array.new(1000, 0) }
    @instructions = instructions;
    @on = 0
  end

  def run(mode)
    @instructions.each do |instr|
      type, x1, y1, x2, y2 = instr.match(@@pattern).captures
      case type
      when "turn on" then
        change_brightness(x1.to_i, y1.to_i, x2.to_i, y2.to_i, 1, mode)
      when "turn off" then
        change_brightness(x1.to_i, y1.to_i, x2.to_i, y2.to_i, -1, mode)
      when "toggle" then
        toggle(x1.to_i, y1.to_i, x2.to_i, y2.to_i, mode)
      else raise ArgumentError "Unknown instruction type #{type}"
      end
    end
    @on
  end

  private
  def change_brightness(x1, y1, x2, y2, delta, mode)
    for x in (x1..x2) do
      for y in (y1..y2) do
        if mode == :simple && (delta > 0 && @lights[x][y] == 0 || delta < 0 && @lights[x][y] == 1) ||
           mode == :advanced && (delta > 0 || @lights[x][y] > 0) then
          @on += delta
          @lights[x][y] += delta
        end
      end
    end
  end

  def toggle(x1, y1, x2, y2, mode)
    for x in (x1..x2) do
      for y in (y1..y2) do
        if mode == :simple then
          @on += @lights[x][y] > 0 ? -1 : 1
          @lights[x][y] = 1 - @lights[x][y]
        else
          @on += 2
          @lights[x][y] += 2
        end
      end
    end
  end
end
